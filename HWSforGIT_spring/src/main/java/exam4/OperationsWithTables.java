package exam4;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.io.File;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class OperationsWithTables
{
    private EntityManager manager;

    public OperationsWithTables(EntityManager manager) {
        this.manager = manager;
    }

    public void getAllMountains(String exercise)
    {
        /* 2. составить запросы для получения: 2.1 всех гор */
        Query query1 = manager.createQuery("SELECT g FROM Mountain g");
        List<Mountain> mountains1 = (List<Mountain>)query1.getResultList();
    //    System.out.println("\n2. составить запросы для получения: 2.1 всех гор: " + mountains1);
        WriteToFile writeToFile = new WriteToFile(new File("exam4.txt"));
        writeToFile.writeToFileList(exercise, mountains1);
    }

    public void getMountainsBtwnHeight(String exercise, int min, int max)
    {
        /* 2. составить запросы для получения: 2.2 гор с высотой от min до max */
        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery<Mountain> criteriaQuery = builder.createQuery(Mountain.class);
        Root<Mountain> root = criteriaQuery.from(Mountain.class);
        Predicate condition2 = builder.between(root.get("height"), min, max); //.equal(root.get("name"), mountain3.getName());
        criteriaQuery.select(root).where(condition2);
        TypedQuery<Mountain> typedQuery2 = manager.createQuery(criteriaQuery);
        List<Mountain> mountainBtwnHeight = typedQuery2.getResultList();
//        System.out.println("\n2. составить запросы для получения: 2.2 гор с " +
//                "высотой от min(3_000) до max(7_000): " + mountainBtwnHeight);
        WriteToFile writeToFile = new WriteToFile(new File("exam4.txt"));
        writeToFile.writeToFileList(exercise, mountainBtwnHeight);
    }

    public void getClimbingGroupNotYetGoingUp(String exercise)
    {
        List<ClimbingGroup> climbingGroupNotYetGoingUpList = new ArrayList<>();

        Query queryCG = manager.createQuery("SELECT g.id FROM ClimbingGroup g");
        List<Integer> pkCG = (List<Integer>)queryCG.getResultList();

        CriteriaBuilder builderCG = manager.getCriteriaBuilder();
        CriteriaQuery<ClimbingGroup> criteriaQueryCG = builderCG.createQuery(ClimbingGroup.class);
        Root<ClimbingGroup> rootCG = criteriaQueryCG.from(ClimbingGroup.class);
        for (Integer integer : pkCG)
        {
            Predicate conditionCG = builderCG.equal(rootCG.get("id"), integer);
            criteriaQueryCG.select(rootCG).where(conditionCG);
            TypedQuery<ClimbingGroup> typedQueryCG = manager.createQuery(criteriaQueryCG);
            ClimbingGroup iterPKcg = typedQueryCG.getSingleResult();
            if(iterPKcg.getStartClimbing().isAfter(LocalDateTime.now()))
                climbingGroupNotYetGoingUpList.add(iterPKcg);
        }
//        System.out.println("2.3 групп, которые еще не начали восхождения на горы относительно текущей даты");
        WriteToFile writeToFile = new WriteToFile(new File("exam4.txt"));
        if(climbingGroupNotYetGoingUpList.isEmpty())
        {
            String exercise1 = exercise + "\n ВСЕ ГРУППЫ УЖЕ НАЧАЛИ ВОСХОЖДЕНИЯ В ГОРЫ!))";
            writeToFile.writeToFileList(exercise1, climbingGroupNotYetGoingUpList);
        } else {
            writeToFile.writeToFileList(exercise, climbingGroupNotYetGoingUpList);
        }
    }

    public void getClimberByNameEmail(String exercise,String climberName,String climberEmail)
    {
        CriteriaBuilder builderClimber = manager.getCriteriaBuilder();
        CriteriaQuery<Climber> criteriaQueryClimber = builderClimber.createQuery(Climber.class);
        Root<Climber> rootClimber = criteriaQueryClimber.from(Climber.class);
        Predicate condition4_1 = builderClimber.equal(rootClimber.get("fullName"), climberName);
        Predicate condition4_2 = builderClimber.equal(rootClimber.get("email"), climberEmail);
        Predicate condition4 = builderClimber.and(condition4_1,condition4_2);
        criteriaQueryClimber.select(rootClimber).where(condition4);
        TypedQuery<Climber> typedQuery4 = manager.createQuery(criteriaQueryClimber);
        Climber climberGetByNameEmail = typedQuery4.getSingleResult();
        String climberGetByNameEmailString = climberGetByNameEmail.toString();
//        System.out.println("\n2. составить запросы для получения: 2.4 альпиниста по имени и email: "
//                + climberGetByNameEmail);
        WriteToFile writeToFile = new WriteToFile(new File("exam4.txt"));
        writeToFile.writeToFileString(exercise, climberGetByNameEmailString);
    }

    public void getMountainByName(String exercise, String mountainName)
    {
        /* 2. составить запросы для получения: 2.5 гору по названию */
        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery<Mountain> criteriaQuery = builder.createQuery(Mountain.class);
        Root<Mountain> root = criteriaQuery.from(Mountain.class);
        Predicate condition5 = builder.equal(root.get("name"), mountainName);
        criteriaQuery.select(root).where(condition5);
        TypedQuery<Mountain> typedQuery5 = manager.createQuery(criteriaQuery);
        Mountain mountainGetByName = typedQuery5.getSingleResult();
        String mountainGetByNameString = mountainGetByName.toString();
        //System.out.println("\n2. составить запросы для получения: 2.5 гору по названию: " + mountainGetByName);
        WriteToFile writeToFile = new WriteToFile(new File("exam4.txt"));
        writeToFile.writeToFileString(exercise, mountainGetByNameString);
    }

    public void insertIntoTables()
    {
        Mountain mountain1 = new Mountain("mountain1", 1002);
        Mountain mountain2 = new Mountain("mountain2", 2003);
        Mountain mountain3 = new Mountain("mountain3", 3004);
        Mountain mountain4 = new Mountain("mountain4", 4005);
        Mountain mountain5 = new Mountain("mountain5", 5006);
        Mountain mountain6 = new Mountain("mountain6", 6007);
        Mountain mountain7 = new Mountain("mountain7", 7008);
        Climber climber1 = new Climber("climber1",21,"climber1@email.com", UUID.randomUUID());
        Climber climber2 = new Climber("climber2",22,"climber2@email.com", UUID.randomUUID());
        Climber climber3 = new Climber("climber3",23,"climber3@email.com", UUID.randomUUID());
        Climber climber4 = new Climber("climber4",24,"climber4@email.com", UUID.randomUUID());
        Climber climber5 = new Climber("climber5",25,"climber5@email.com", UUID.randomUUID());
        Climber climber6 = new Climber("climber6",26,"climber6@email.com", UUID.randomUUID());
        ClimbingGroup climbingGroup1 = new ClimbingGroup();
        climbingGroup1.setMountainNameHeight(mountain1);
        climbingGroup1.setClimbingGroup(new Climber[]{climber1,climber3,climber2,climber5});
        climbingGroup1.setStartClimbing((long) (Math.random() * 7));
        ClimbingGroup climbingGroup2 = new ClimbingGroup();
        climbingGroup2.setMountainNameHeight(mountain3);
        climbingGroup2.setClimbingGroup(new Climber[]{climber4,climber6,climber2,climber5});
        climbingGroup2.setStartClimbing((long) (Math.random() * 7));
        ClimbingGroup climbingGroup3 = new ClimbingGroup();
        climbingGroup3.setMountainNameHeight(mountain5);
        climbingGroup3.setClimbingGroup(new Climber[]{climber1,climber3,climber6,climber5});
        climbingGroup3.setStartClimbing((long) (Math.random() * 7));
        ClimbingGroup climbingGroup4 = new ClimbingGroup();
        climbingGroup4.setMountainNameHeight(mountain7);
        climbingGroup4.setClimbingGroup(new Climber[]{climber4,climber3,climber2,climber6});
        climbingGroup4.setStartClimbing((long) (Math.random() * 7));

        manager.getTransaction().begin();
        manager.persist(climber1);
        manager.persist(climber2);
        manager.persist(climber3);
        manager.persist(climber4);
        manager.persist(climber5);
        manager.persist(climber6);
        manager.persist(mountain1);
        manager.persist(mountain2);
        manager.persist(mountain3);
        manager.persist(mountain4);
        manager.persist(mountain5);
        manager.persist(mountain6);
        manager.persist(mountain7);
        manager.persist(climbingGroup1);
        manager.persist(climbingGroup2);
        manager.persist(climbingGroup3);
        manager.persist(climbingGroup4);
        manager.getTransaction().commit();

    }
}
