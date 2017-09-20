package seu.controller;

import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;
import org.springframework.beans.factory.annotation.Autowired;
import seu.service.CourseSelectService;
import org.springframework.stereotype.Component;
import seu.domain.Course;
import seu.service.CourseService;

@Component
public class courseTestController {
    @Autowired
    CourseService courseService=new CourseService();

    @Autowired
    CourseSelectService     courseSelectService=new CourseSelectService();
    @FXML
    private TableView<studentSelectCourseTable> courseTable;

    @FXML
    private TableColumn<studentSelectCourseTable, String> courseName;
    @FXML
    private TableColumn<studentSelectCourseTable, String> choice;

    @FXML
    private TableColumn<studentSelectCourseTable, Integer> CourseID,Credit,period,teacherID;

    @FXML
    private TableView<studentCourseSelecTable> resultTable;

    @FXML
    private TableColumn<studentCourseSelecTable, String> CourseName;
    @FXML
    private TableColumn<studentCourseSelecTable, String> cancel;

    @FXML
    private TableColumn<studentCourseSelecTable, Integer> courseID,credit,Period,TeacherID,grades;

    private int studentID;
    private ObservableList<studentCourseSelecTable> couResultLists =FXCollections.observableArrayList();
     private ObservableList<studentSelectCourseTable> couLists= FXCollections.observableArrayList();


    public ObservableList<studentSelectCourseTable> getCourseData() {


        courseService.queryAll();
        for(int i=0;i<courseService.queryAll().size();i++)
       {
                       studentSelectCourseTable cou= new studentSelectCourseTable(courseService.queryAll().get(i).getCourseName(),
                       courseService.queryAll().get(i).getCourseId(), courseService.queryAll().get(i).getCredit(),courseService.queryAll().get(i).getPeriod(),
                       courseService.queryAll().get(i).getTeacherId());

               couLists.add(i,cou);

         }




        return couLists;
    }



    public void showCourseTable(final ObservableList<studentSelectCourseTable> couLists) {
        courseName.setCellValueFactory(new PropertyValueFactory<studentSelectCourseTable,String>("courseName"));

        CourseID.setCellValueFactory(new PropertyValueFactory<studentSelectCourseTable,Integer>("CourseID"));
        Credit.setCellValueFactory(new PropertyValueFactory<studentSelectCourseTable,Integer>("Credit"));
        period.setCellValueFactory(new PropertyValueFactory<studentSelectCourseTable,Integer>("period"));
        teacherID.setCellValueFactory(new PropertyValueFactory<studentSelectCourseTable,Integer>("teacherID"));

        choice.setCellValueFactory(new PropertyValueFactory<studentSelectCourseTable,String>("DUMMY"));

        Callback<TableColumn<studentSelectCourseTable, String>, TableCell<studentSelectCourseTable, String>> cellFactory
                = //
                new Callback<TableColumn<studentSelectCourseTable, String>, TableCell<studentSelectCourseTable, String>>() {
                    @Override
                    public TableCell call(final TableColumn<studentSelectCourseTable, String> param) {
                        final TableCell<studentSelectCourseTable, String> cell = new TableCell<studentSelectCourseTable, String>() {

                            final Button btn = new Button("确认选课");

                            @Override
                            public void updateItem(String item, boolean empty) {
                                super.updateItem(item, empty);
                                if (empty) {
                                    setGraphic(null);
                                    setText(null);
                                } else {
                                    btn.setOnAction(new EventHandler<ActionEvent>(){
                                        @Override
                                        public void handle(ActionEvent event) {
                                            System.out.println("Button clicked");
                                            btn.setDisable(true);
                                            // CourseSelectService cou = new CourseSelectService();
                                            courseSelectService. insertCourseSelect(studentID,couLists.get(getIndex()).getCourseID());

                                        }
                                    });

                                    setGraphic(btn);
                                    setText(null);
                                }
                            }
                        };
                        return cell;
                    }
                };

        choice.setCellFactory(cellFactory);

        courseTable.setItems(this.getCourseData());
    }
    public void selectCourse(Event event) {
        couLists =FXCollections.observableArrayList();
        this.showCourseTable(this.getCourseData());
        int end=courseService.queryAll().size()*2-1;
        int start=courseService.queryAll().size()-1;
        couLists.remove(start,end);
        courseTable.refresh();

    }



    public ObservableList<studentCourseSelecTable> getCourseResultData() {

        for(int i=0;i<  courseSelectService.queryCourseByStudentId(studentID).size();i++)
       {
              studentCourseSelecTable stu = new   studentCourseSelecTable(  courseSelectService.queryCourseByStudentId(studentID).get(i).getCourseName(),
                      courseSelectService.queryCourseByStudentId(studentID).get(i).getCourseId(),   courseSelectService.queryCourseByStudentId(studentID).get(i).getCredit(),  courseSelectService.queryCourseByStudentId(studentID).get(i).getPeriod(),
                      courseSelectService.queryCourseByStudentId(studentID).get(i).getTeacherId(), courseSelectService.queryGradeByCourseIDAndStudentID(studentID,courseSelectService.queryCourseByStudentId(studentID).get(i).getCourseId()));

            couResultLists.add(stu);

         }

        return  couResultLists;
    }


    public void showCourseResultTable(ObservableList<studentCourseSelecTable> couLists) {
        CourseName.setCellValueFactory(new PropertyValueFactory<studentCourseSelecTable,String>("CourseName"));
        courseID.setCellValueFactory(new PropertyValueFactory<studentCourseSelecTable,Integer>("courseID"));
        credit.setCellValueFactory(new PropertyValueFactory<studentCourseSelecTable,Integer>("credit"));
        Period.setCellValueFactory(new PropertyValueFactory<studentCourseSelecTable,Integer>("Period"));
        TeacherID.setCellValueFactory(new PropertyValueFactory<studentCourseSelecTable,Integer>("TeacherID"));
        grades.setCellValueFactory(new PropertyValueFactory<studentCourseSelecTable,Integer>("grades"));

        cancel.setCellValueFactory(new PropertyValueFactory<studentCourseSelecTable,String>("DUMMY"));

        Callback<TableColumn<studentCourseSelecTable, String>, TableCell<studentCourseSelecTable, String>> cellFactory
                = //
                new Callback<TableColumn<studentCourseSelecTable, String>, TableCell<studentCourseSelecTable, String>>() {
                    @Override
                    public TableCell call(final TableColumn<studentCourseSelecTable, String> param) {
                        final TableCell<studentCourseSelecTable, String> cell = new TableCell<studentCourseSelecTable, String>() {

                            final Button btn = new Button("取消选课");

                            @Override
                            public void updateItem(String item, boolean empty) {
                                super.updateItem(item, empty);
                                if (empty) {
                                    setGraphic(null);
                                    setText(null);
                                } else {
                                    btn.setOnAction(new EventHandler<ActionEvent>(){
                                        @Override
                                        public void handle(ActionEvent event) {
                                            System.out.println("Button clicked");

                                            show(getIndex());


                                        }
                                    });
                                    setGraphic(btn);
                                    setText(null);
                                }
                            }
                        };
                        return cell;
                    }
                };

        cancel.setCellFactory(cellFactory);



        resultTable.setItems(this.getCourseResultData());
    }

    public void show(int a)
    {


        courseSelectService.deleteCourseSelectByCourseIDAndStudentID(studentID, couResultLists.get(a).getCourseID());
        couResultLists.remove(a);
        resultTable.refresh();


    }

    public void courseResult(Event event) {
        couResultLists =FXCollections.observableArrayList();
        this.showCourseResultTable(this.getCourseResultData());

        int end=  courseSelectService.queryCourseByStudentId(studentID).size()*2-1;
        int start=  courseSelectService.queryCourseByStudentId(this.studentID).size()-1;
        couResultLists.remove(start,end);
        resultTable.refresh();

    }

    public void getstudentID(int  id)
    {
        studentID=id;
    }

}
