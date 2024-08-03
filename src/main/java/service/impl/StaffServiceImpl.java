package service.impl;

import entity.Staff;
import repository.StaffRepository;
import service.StaffService;

import java.util.List;

public class StaffServiceImpl implements StaffService<Staff> {
    private final StaffRepository staffRepository;

    public StaffServiceImpl(StaffRepository staffRepository) {
        this.staffRepository = staffRepository;
    }

    @Override
    public void add(Staff entity) {
        try{
         staffRepository.add(entity);
        }catch(Exception e){
            System.out.println("Expcetion while adding staff" + e.getMessage());
        }
    }

    @Override
    public void delete(Staff entity) {
        try{
            staffRepository.delete(entity);
        }catch(Exception e){
            System.out.println("Expcetion while deleting staff" + e.getMessage());
        }
    }

    @Override
    public void deleteById(Long id) {
        try{
            staffRepository.deleteById(id);
        }catch(Exception e){
            System.out.println("Expcetion while deleting staff" + e.getMessage());
        }
    }

    @Override
    public void update(Staff entity) {
        try{
         staffRepository.update(entity);
        }catch(Exception e){
            System.out.println("Expcetion while updating staff" + e.getMessage());
        }
    }

    @Override
    public Staff findById(Class<Staff> entity,Long id) {
        try{
            return staffRepository.findById(entity,id);
        }catch(Exception e){
            System.out.println("Expcetion while finding staff" + e.getMessage());
        }
        return null;
    }

    @Override
    public List<Staff> findAll(Class<Staff> entity) {
       try{
           return staffRepository.findAll(entity);
       }catch(Exception e){
           System.out.println("Expcetion while finding staff" + e.getMessage());
       }
       return null;
    }
}
