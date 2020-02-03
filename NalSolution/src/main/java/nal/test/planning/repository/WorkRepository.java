package nal.test.planning.repository;

import java.util.List;

import nal.test.planning.enity.Work;

/**
 * Repository of work
 * @author TuanNH
 */
public interface WorkRepository extends BaseGeneric<Work, Integer>{
    /**
     * Get list work and paging
     * @param pageNum page number current
     * @param limit limit page
     * @return List<Work> result list
     */
    public List<Work> getListWork(int pageNum, int limit);

    /**
     * Get a work
     * @param id
     * @return work object work
     */
    public Work getWork(int id);

    /**
     * Update a work
     * @param workJson object of work
     * @return int result after execute delete
     */
    public int updateWork(Work work);

    /**
     * Delete a work
     * @param id id of work
     * @return int result after execute delete
     */
    public int deleteWork(int id);

    /**
     * Insert a new work
     * @param work object of work
     * @return int result after execute add
     */
    public int addWork(Work work);

    /**
     * Count all records work
     * @return amount of records 
     */
    public int countAllWork();
}
