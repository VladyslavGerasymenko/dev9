package vladyslav.goit;

import jakarta.persistence.*;
import jakarta.persistence.criteria.*;
import org.apache.log4j.Logger;
import vladyslav.goit.data.*;

import java.util.List;

public class Criteria {

    private static final Logger LOGGER = Logger.getLogger(Criteria.class.getName());

    public void criteriaSelectParticipant(EntityManager em) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Object[]> criteriaQuery = cb.createQuery(Object[].class);

        Root<Resident> root = criteriaQuery.from(Resident.class);
        Join<ParticipantOsbb, Resident> residentJoin = root.join("participantOsbb");
        Join<Resident, Apartament> apartamentJoin = root.join("apartament");
        Join<Apartament, BuildingForApartament> buildingForApartamentJoin = apartamentJoin.join("buildingForApartament");
        Join<BuildingForApartament, Building> buildingJoin = buildingForApartamentJoin.join("building");

        criteriaQuery.multiselect(
                residentJoin.get("id"),
                residentJoin.get("fio"),
                residentJoin.get("email"),
                buildingJoin.get("address"),
                apartamentJoin.get("apartament"),
                apartamentJoin.get("square")
        );

        Predicate entryCar = cb.equal(root.get("entry"), false);
        Subquery<Long> subquery = criteriaQuery.subquery(Long.class);
        Root<Resident> subRoot = subquery.from(Resident.class);
        Join<ParticipantOsbb, Resident> subResidentJoin = subRoot.join("participantOsbb");
        Join<Resident, Apartament> subApartamentJoin = subRoot.join("apartament");

        subquery.select(subResidentJoin.get("id"))
                .groupBy(subResidentJoin.get("id"))
                .having(cb.lt(cb.count(subApartamentJoin.get("id")), 2L));

        criteriaQuery.where(cb.and(entryCar, residentJoin.get("id").in(subquery)));
        criteriaQuery.orderBy(cb.desc(residentJoin.get("fio")));

        TypedQuery<Object[]> q = em.createQuery(criteriaQuery);
        List<Object[]> result = q.getResultList();
        outOfConsoleAndLog(result);
    }

    private void outOfConsoleAndLog(List<Object[]> file) {
        int count = 0;
        for (Object[] row : file) {
            Long id = (Long) row[0];
            String fio = (String) row[1];
            String email = (String) row[2];
            String address = (String) row[3];
            int apartament = (int) row[4];
            float square = (float) row[5];
            count++;
            LOGGER.trace("№: " + count
                    + ", ID: " + id
                    + ", FIO: " + fio
                    + ", Email: " + email
                    + ", Address: " + address
                    + ", Apartament: " + apartament
                    + ", Square: " + square);
        }
    }
}
