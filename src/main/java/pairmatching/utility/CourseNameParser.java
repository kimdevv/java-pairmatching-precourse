package pairmatching.utility;

import pairmatching.enumerate.Course;

public class CourseNameParser {
    public static String[] parse(Course[] courses) {
        String[] courseNames = {"", "", "", "", "", ""};
        for (Course course : courses) {
            courseNames[course.getLevel()] += course.getName() + " | ";
            System.out.println(courseNames[course.getLevel()]);
        }
        for (String courseName : courseNames) {
            courseName = courseName.substring(0, courseName.lastIndexOf(" | "));
        }
        return courseNames;
    }
}
