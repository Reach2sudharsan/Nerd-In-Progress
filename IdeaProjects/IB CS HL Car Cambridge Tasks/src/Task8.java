import java.util.ArrayList;

public class Task8 {
    public static void main(String[] args) {
        Course MyCourse = new Course("Computing", 10);

        MyCourse.AddAssessment("Programming", 100);

        MyCourse.AddLesson("Problem Solving", 60, false);
        MyCourse.AddLesson("Programming", 120, true);
        MyCourse.AddLesson("Theory", 60, false);

        MyCourse.OutputCourseDetails();
    }
}

class Course {
    private String CourseTitle;
    private int MaxStudents;
    private int NumberOfLessons;
    private ArrayList<Lesson> CourseLesson;
    private Assessment CourseAssessment;

    public Course(String CourseTitle, int MaxStudents) {
        this.CourseTitle = CourseTitle;
        this.MaxStudents = MaxStudents;
        this.NumberOfLessons = 0;
        this.CourseLesson = new ArrayList<Lesson>();
    }

    public void AddLesson(String t, int d, boolean r) {
        NumberOfLessons += 1;
        CourseLesson.add(new Lesson(t, d, r));
    }

    public void AddAssessment(String t, int m) {
        CourseAssessment = new Assessment(t, m);
    }

    public void OutputCourseDetails() {
        System.out.println(CourseTitle + ", Maximum number: " + MaxStudents);
        for (int i = 0; i < CourseLesson.size(); i++) {
            CourseLesson.get(i).OutputLessonDetails();
        }
    }
}

class Lesson {
    private String LessonTitle;
    private int DurationMinutes;
    private boolean RequiresLab;

    public Lesson(String LessonTitle, int DurationMinutes, boolean RequriresLab) {
        this.LessonTitle = LessonTitle;
        this.DurationMinutes = DurationMinutes;
        this.RequiresLab = RequriresLab;
    }

    public void OutputLessonDetails() {
        System.out.println("Lesson title: " + LessonTitle);
        System.out.println("Duration minutes: " + DurationMinutes);
        System.out.println("If requires lab: " + RequiresLab);
    }
}

class Assessment {
    private String AssessmentTitle;
    private int MaxMarks;

    public Assessment(String AssessmentTitle, int MaxMarks) {
        this.AssessmentTitle = AssessmentTitle;
        this.MaxMarks = MaxMarks;
    }

    public void OutputAssessmentDetails() {
        System.out.println("Assessment title: " + AssessmentTitle);
        System.out.println("Max marks: " + MaxMarks);
    }
}
