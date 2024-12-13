package dao;

import java.util.List;
import model.Employer;

public interface GeneriqueI <T>{
    boolean addEmployer(T t);
    boolean updateEmployer(T  t);
    boolean deleteEmployer(int id);
    List<Employer> getAllEmployers();
}
