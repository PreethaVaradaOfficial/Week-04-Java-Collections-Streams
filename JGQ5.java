import java.util.*;
abstract class JobRole {
    private String candidateName;
    private int experienceYears;

    public JobRole(String candidateName, int experienceYears) {
        this.candidateName = candidateName;
        this.experienceYears = experienceYears;
    }

    public String getCandidateName() {
        return candidateName;
    }

    public int getExperienceYears() {
        return experienceYears;
    }

    public abstract String getRole();

    @Override
    public String toString() {
        return getRole() + " | " + candidateName + " | " + experienceYears + " years";
    }
}
class SoftwareEngineer extends JobRole {
    public SoftwareEngineer(String candidateName, int experienceYears) {
        super(candidateName, experienceYears);
    }

    public String getRole() {
        return "Software Engineer";
    }
}
class DataScientist extends JobRole {
    public DataScientist(String candidateName, int experienceYears) {
        super(candidateName, experienceYears);
    }

    public String getRole() {
        return "Data Scientist";
    }
}
class ProductManager extends JobRole {
    public ProductManager(String candidateName, int experienceYears) {
        super(candidateName, experienceYears);
    }

    public String getRole() {
        return "Product Manager";
    }
}
class Resume<T extends JobRole> {
    private T jobRole;

    public Resume(T jobRole) {
        this.jobRole = jobRole;
    }

    public void displayResume() {
        System.out.println("Processing Resume: " + jobRole);
    }

    public T getJobRole() {
        return jobRole;
    }
}
class ResumeScreeningSystem {
    public static <T extends JobRole> void screenResume(Resume<T> resume) {
        T job = resume.getJobRole();
        System.out.println("Screening " + job.getRole() + " Resume for: " + job.getCandidateName());
        if (job.getExperienceYears() >= 3) {
            System.out.println("✅ Shortlisted for next round");
        } else {
            System.out.println("❌ Not enough experience");
        }
    }
    public static void bulkScreen(List<? extends JobRole> resumes) {
        for (JobRole job : resumes) {
            System.out.println("Bulk Screening: " + job);
            if (job.getExperienceYears() >= 3) {
                System.out.println("✅ Passed");
            } else {
                System.out.println("❌ Rejected");
            }
        }
    }
}
class ResumeScreeningApp {
    public static void main(String[] args) {
        Resume<SoftwareEngineer> seResume = new Resume<>(new SoftwareEngineer("Alice", 5));
        Resume<DataScientist> dsResume = new Resume<>(new DataScientist("Bob", 2));
        Resume<ProductManager> pmResume = new Resume<>(new ProductManager("Carol", 4));
        ResumeScreeningSystem.screenResume(seResume);
        ResumeScreeningSystem.screenResume(dsResume);
        ResumeScreeningSystem.screenResume(pmResume);

        System.out.println("\n--- Bulk Screening ---");
        List<JobRole> mixedResumes = Arrays.asList(
                new SoftwareEngineer("David", 1),
                new DataScientist("Eva", 3),
                new ProductManager("Frank", 5)
        );

        ResumeScreeningSystem.bulkScreen(mixedResumes);
    }
}
//✅❌