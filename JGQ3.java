import java.util.*;
abstract class CourseType {
    private String evaluationMethod;

    public CourseType(String evaluationMethod) {
        this.evaluationMethod = evaluationMethod;
    }

    public String getEvaluationMethod() {
        return evaluationMethod;
    }

    public abstract String getDetails();
}
class ExamCourse extends CourseType {
    private int numberOfExams;

    public ExamCourse(int numberOfExams) {
        super("Exam-Based");
        this.numberOfExams = numberOfExams;
    }

    @Override
    public String getDetails() {
        return "Exam Course | Exams: " + numberOfExams;
    }
}

class AssignmentCourse extends CourseType {
    private int numberOfAssignments;

    public AssignmentCourse(int numberOfAssignments) {
        super("Assignment-Based");
        this.numberOfAssignments = numberOfAssignments;
    }

    @Override
    public String getDetails() {
        return "Assignment Course | Assignments: " + numberOfAssignments;
    }
}

class ResearchCourse extends CourseType {
    private String researchTopic;

    public ResearchCourse(String researchTopic) {
        super("Research-Based");
        this.researchTopic = researchTopic;
    }

    @Override
    public String getDetails() {
        return "Research Course | Topic: " + researchTopic;
    }
}
class Course<T extends CourseType> {
    private String courseName;
    private String department;
    private T courseType;

    public Course(String courseName, String department, T courseType) {
        this.courseName = courseName;
        this.department = department;
        this.courseType = courseType;
    }

    public T getCourseType() {
        return courseType;
    }

    public String getInfo() {
        return "Course: " + courseName + " | Department: " + department + " | Type: " + courseType.getEvaluationMethod();
    }

    public String getFullDetails() {
        return getInfo() + " | " + courseType.getDetails();
    }
}
class CourseUtils {
    public static void displayCourseList(List<? extends Course<? extends CourseType>> courseList) {
        for (Course<? extends CourseType> c : courseList) {
            System.out.println(c.getFullDetails());
        }
    }
}
class UniversityCourseSystem {
    public static void main(String[] args) {
        List<Course<? extends CourseType>> courseCatalog = new ArrayList<>();

        Course<ExamCourse> cs101 = new Course<>("CS101", "Computer Science", new ExamCourse(2));
        Course<AssignmentCourse> eng205 = new Course<>("ENG205", "English", new AssignmentCourse(5));
        Course<ResearchCourse> phy500 = new Course<>("PHY500", "Physics", new ResearchCourse("Quantum Entanglement"));

        courseCatalog.add(cs101);
        courseCatalog.add(eng205);
        courseCatalog.add(phy500);

        System.out.println("=== University Course Catalog ===");
        CourseUtils.displayCourseList(courseCatalog);
    }
}
