package util;

import entity.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import lombok.Getter;
import menu.*;
import repository.*;
import repository.impl.*;
import service.*;
import service.impl.*;

public class ApplicationContext {
    private static ApplicationContext instance;
    private EntityManagerFactory emf;
    private EntityManager em;

    @Getter
    private final UserService userService;
    @Getter
    private final UserRepository userRepository;
    @Getter
    private final StudentRepository studentRepository;
    @Getter
    private final StudentService<Student> studentSerivce;
    @Getter
    private final FacultyRepository facultyRepository;
    @Getter
    private final FacultyService<Faculty> facultyService;
    @Getter
    private final CourseRepository courseRepository;
    @Getter
    private final CourseService<Course> courseService;
    @Getter
    private final SelectUnitRepository selectUnitRepository;
    @Getter
    private final SelectUnitService<SelectUnit> selectUnitService;
    @Getter
    private final StaffRepository staffRepository;
    @Getter
    private final StaffService<Staff> staffService;

    @Getter
    private final LoginMenu loginMenu;
    @Getter
    private final StaffMenu staffMenu;
    @Getter
    private final StudentMenu studentMenu;
    @Getter
    private final FacultyMenu facultyMenu;
    @Getter
    private final MainMenu mainMenu;

    private ApplicationContext() {
        this.emf = Persistence.createEntityManagerFactory("default");
        this.em = emf.createEntityManager();
        studentRepository = new StudentRepositoryImpl(em);
        BaseEntityRepository<BaseEntity> baseEntityRepository = new BaseEntityRepositoryImpl<BaseEntity>(em);
        facultyRepository = new FacultyRepositoryImpl(em);
        facultyService = new FacultyServiceImpl(facultyRepository);
        courseRepository = new CourseRepositoryImpl<Course>(em);
        courseService = new CourseServiceImpl(courseRepository);
        selectUnitRepository = new SelectUnitRepositoryImpl(em);
        studentSerivce = new StudentServiceImpl(studentRepository, courseService);
        selectUnitService = new SelectUnitServiceImpl(selectUnitRepository);
        staffRepository = new StaffRepositoryImpl(em);
        staffService = new StaffServiceImpl(staffRepository, studentSerivce, facultyService, courseService);
        userRepository = new UserRepositoryImpl(em);
        userService = new UserServiceImpl(userRepository);

        loginMenu = new LoginMenu(userService);
        staffMenu = new StaffMenu(studentSerivce,facultyService,staffService);
        studentMenu = new StudentMenu(studentSerivce,courseService, selectUnitService);
        facultyMenu = new FacultyMenu(facultyService,courseService,studentSerivce,selectUnitService);
        mainMenu = new MainMenu(loginMenu, staffMenu, studentMenu, facultyMenu);
    }

    public static ApplicationContext getInstance() {
        if (instance == null) {
            instance = new ApplicationContext();
        }
        return instance;
    }

    public EntityManagerFactory getEntityManagerFactory() {
        if (emf == null) {
            emf = Persistence.createEntityManagerFactory("default");
        }
        return emf;
    }

    public EntityManager getEntityManager() {
        if (em == null) {
            em = emf.createEntityManager();
        }
        return em;
    }
}
