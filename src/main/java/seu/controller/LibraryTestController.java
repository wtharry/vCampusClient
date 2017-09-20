package seu.controller;

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
import org.springframework.stereotype.Component;
import seu.service.LibraryService;
import seu.service.StudentService;

import java.text.SimpleDateFormat;

@Component
public class LibraryTestController {

    @Autowired
    LibraryService libraryService=new LibraryService();

    @Autowired
    StudentService studentService=new StudentService();
    @FXML
    private TableView<studentLibraryTable> studentBookTable;

    @FXML
    private TableColumn<studentLibraryTable, String> bookName, startDate, returnBook;

    @FXML
    private TableColumn<studentLibraryTable, Integer> bookID;

   private  ObservableList<studentLibraryTable> bookLists= FXCollections.observableArrayList();

    private int studentID;



    public ObservableList<studentLibraryTable> getBooksData() {
       System.out.print(this.studentID);
       System.out.print( libraryService.getAllBookList(this.studentID).size());
        for(int i=0;i< libraryService.getAllBookList(this.studentID).size();i++)
       {
             SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
             String date=sdf.format( libraryService.getAllBookList(this.studentID).get(i).getStartDate());
             studentLibraryTable stu = new studentLibraryTable( libraryService. getAllBookList(this.studentID).get(i).getBookName(),
                     libraryService.getAllBookList(this.studentID).get(i).getBookId(),date);

               bookLists.add(stu);


         }


        System.out.print(3);

        return bookLists;
    }


    public void showBooksTable(final ObservableList<studentLibraryTable> bookLists) {
        bookName.setCellValueFactory(new PropertyValueFactory<studentLibraryTable, String>("bookName"));
        bookID.setCellValueFactory(new PropertyValueFactory<studentLibraryTable, Integer>("bookID"));
        startDate.setCellValueFactory(new PropertyValueFactory<studentLibraryTable, String>("startDate"));
        returnBook.setCellValueFactory(new PropertyValueFactory<studentLibraryTable, String>("DUMMY"));

      Callback<TableColumn<studentLibraryTable, String>, TableCell<studentLibraryTable, String>> cellFactory
                = //
                new Callback<TableColumn<studentLibraryTable, String>, TableCell<studentLibraryTable, String>>() {
                    @Override
                    public TableCell call(final TableColumn<studentLibraryTable, String> param) {
                        final TableCell<studentLibraryTable, String> cell = new TableCell<studentLibraryTable, String>() {

                            final Button btn = new Button("确认还书");

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
                                            System.out.println(getIndex());
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

        returnBook.setCellFactory(cellFactory);

        studentBookTable.setItems(this.getBooksData());
    }



    public void returnTab(Event event) {

        this.showBooksTable(this.getBooksData());
        int end= libraryService.getAllBookList(this.studentID).size()*2-1;
       int start=libraryService.getAllBookList(this.studentID).size()-1;
       bookLists.remove(start,end);
        studentBookTable.refresh();
        System.out.print("图书馆");
    }

    public void getStudentID( int id)
    {
        this.studentID=id;
        this.showBooksTable(this.getBooksData());
       int end= libraryService.getAllBookList(this.studentID).size()*2-1;
       int start=libraryService.getAllBookList(this.studentID).size()-1;
        bookLists.remove(start,end);
        studentBookTable.refresh();
        System.out.print("图书馆");
    }
    public void show(int index)
    {
        bookLists.remove(index);
        studentBookTable.refresh();

       libraryService.returnBook(   libraryService.getAllBookList(studentID).get(index).getBookId());
    }



}
