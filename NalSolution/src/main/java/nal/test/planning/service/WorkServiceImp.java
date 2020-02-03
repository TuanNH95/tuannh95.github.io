package nal.test.planning.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nal.test.planning.enity.Work;
import nal.test.planning.repository.WorkRepository;

/**
 * Service implementation of work
 * @author TuanNH
 */
@Service
public class WorkServiceImp implements WorkService{

    /**
     * Injects workRepository
     */
    @Autowired
    WorkRepository workRepository;

    /**
     * Get list work and paging
     * @param pageNum page number current
     * @param limit limit page
     * @return List<Work> result list
     */
    @Override
    public List<Work> getListWork(int pageNum, int limit) {
        return workRepository.getListWork(pageNum, limit);
    }

    /**
     * Get a work
     * @param id
     * @return work object work
     */
    @Override
    public Work getWork(int id) {
        return workRepository.getWork(id);
    }

    /**
     * Update a work
     * @param workJson object of work
     * @return int result after execute delete
     */
    @Override
    public int updateWork(Work work) {
        return workRepository.updateWork(work);
    }

    /**
     * Delete a work
     * @param id id of work
     * @return int result after execute delete
     */
    @Override
    public int deleteWork(int id) {
        return workRepository.deleteWork(id);
    }

    /**
     * Insert a new work
     * @param work object of work
     * @return int result after execute add
     */
    @Override
    public int addWork(Work work) {
        return workRepository.addWork(work);
    }

    /**
     * Count all records work
     * @return amount of records 
     */
    @Override
    public int countAllWork() {
        return workRepository.countAllWork();
    }
}
