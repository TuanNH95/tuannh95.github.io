package nal.test.planning.repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import nal.test.planning.enity.Work;

/**
 * Repository implementation of work
 * @author Administrator
 *
 */
@Repository
public class WorkRepositoryImp extends BaseRepository<Work, Integer> implements WorkRepository{

    /**
     * Get list work and paging
     * @param pageNum page number current
     * @param limit limit page
     * @return List<Work> result list
     */
    @Override
    public List<Work> getListWork(int pageNum, int limit) {
        List<Work> listWork = new ArrayList<Work>();
        try {
            pageNum = pageNum > 0?(pageNum - 1) : pageNum;
            int start = pageNum * limit;
            StringBuilder strQuery = new StringBuilder();
            strQuery.append(" SELECT * FROM work ORDER BY work_name ASC, id_work ASC LIMIT "
                +  start
                +", "
                + limit
            );

            // create query sql to search
            Query query = createNativeSQL(strQuery.toString());
            List<Object[]> result = query.list();
            if (!result.isEmpty()) {

                for (Object[] obj : result) {
                    Work work = new Work();
                    work.setId(Integer.valueOf(String.valueOf(obj[0])));
                    work.setWorkName(String.valueOf(obj[1]));
                    work.setStartingDate(String.valueOf(obj[3]));
                    work.setEndingDate(String.valueOf(obj[2]));
                    work.setStatus(String.valueOf(obj[4]));
                    listWork.add(work);
                }
            }

        } catch (Exception ex) {
            throw ex;
        }
        Collections.sort(listWork);
        return listWork;
    }


    /**
     * Count all records work
     * @return amount of records 
     */
    @Override
    public int countAllWork() {
        int count = 0;
        try {
            StringBuilder strQuery = new StringBuilder();
            strQuery.append(" SELECT count(*) FROM work");

            // create query sql to search
            Query query = createNativeSQL(strQuery.toString());
            List<Object[]> result = query.list();
            if (!result.isEmpty()) {
                count = Integer.valueOf(String.valueOf(result.get(0)));
            }

        } catch (Exception ex) {
            throw ex;
        }
        return count;
    }

    /**
     * Update a work
     * @param workJson object of work
     * @return int result after execute delete
     */
    @Override
    @Transactional
    public int updateWork(Work work) {
        StringBuilder strQuery = new StringBuilder();
        strQuery.append(" UPDATE work ");
        strQuery.append(" SET work_name = '"+ work.getWorkName() +"' ");
        strQuery.append(" , starting_date = '"+ work.getStartingDate() +"' ");
        strQuery.append(" , ending_date = '"+ work.getEndingDate() +"' ");
        strQuery.append(" , status = '"+ work.getStatus() +"' ");
        strQuery.append(" WHERE id_work = ?");
        strQuery.append("  ");

        Query q = createNativeSQL(strQuery.toString());
        q.setParameter(1, work.getId());
        int i = q.executeUpdate();
        return i;
    }

    /**
     * Delete a work
     * @param id id of work
     * @return int result after execute delete
     */
    @Override
    @Transactional
    public int deleteWork(int id) {
        StringBuilder strQuery = new StringBuilder();
        strQuery.append(" DELETE FROM work ");
        strQuery.append(" WHERE id_work = ?");
        strQuery.append("  ");

        Query q = createNativeSQL(strQuery.toString());
        q.setParameter(1, id);
        int i = q.executeUpdate();
        return i;
    }

    /**
     * Insert a new work
     * @param work object of work
     * @return int result after execute add
     */
    @Override
    @Transactional
    public int addWork(Work work) {
        StringBuilder strQuery = new StringBuilder();
        strQuery.append(" INSERT INTO work (work_name, starting_date, ending_date, status)");
        strQuery.append(" VALUES (?, ?, ?, ?)");

        Query q = createNativeSQL(strQuery.toString());
        q.setParameter(1, work.getWorkName());
        q.setParameter(2, work.getStartingDate());
        q.setParameter(3, work.getEndingDate());
        q.setParameter(4, work.getStatus());
        int i = q.executeUpdate();
        return i;
    }

    /**
     * Get a work
     * @param id
     * @return work object work
     */
    @Override
    public Work getWork(int id) {
        Work work = null;
        try {
            StringBuilder strQuery = new StringBuilder();
            strQuery.append(" SELECT * from work where id_work = ?");

            // create query sql to search
            Query query = createNativeSQL(strQuery.toString());
            query.setParameter(1, id);

            List<Object[]> result = query.list();
            if (!result.isEmpty()) {

                // create work and set work from database
                work = new Work();
                for (Object[] obj : result) {
                    work.setId(Integer.valueOf(String.valueOf(obj[0])));
                    work.setWorkName(String.valueOf(obj[1]));
                    work.setStartingDate(String.valueOf(obj[3]));
                    work.setEndingDate(String.valueOf(obj[2]));
                    work.setStatus(String.valueOf(obj[4]));
                }
            }

        } catch (Exception ex) {
            throw ex;
        }

        return work;
    }

}
