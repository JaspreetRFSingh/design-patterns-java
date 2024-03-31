package com.patterns.additional.mvc;

/**
 * Controller - Handles user input and updates model
 */
public class StudentController {
    private Student model;
    private StudentView view;

    public StudentController(Student model, StudentView view) {
        this.model = model;
        this.view = view;
        model.attach(view);
    }

    public void setStudentName(String name) {
        model.setName(name);
    }

    public void setStudentGrade(String grade) {
        model.setGrade(grade);
    }

    public String getStudentName() {
        return model.getName();
    }

    public String getStudentGrade() {
        return model.getGrade();
    }

    public void updateView() {
        view.displayStudentDetails(model);
    }

    public void addView(Observer view) {
        model.attach(view);
    }

    public void removeView(Observer view) {
        model.detach(view);
    }
}
