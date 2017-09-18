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

import java.text.SimpleDateFormat;

@Component
public class LibraryTestController {

    @Autowired
    LibraryService libraryService;
    @FXML
    private TableView<studentLibraryTable> studentBookTable;

    @FXML
    private TableColumn<studentLibraryTable, String> bookName, startDate, returnBook;

    @FXML
    private TableColumn<studentLibraryTable, Integer> bookID;

   private  ObservableList<studentLibraryTable> bookLists= FXCollections.observableArrayList();


    private int studentID;



    public ObservableList<studentLibraryTable> getBooksData() {


        for(int i=0;i< (libraryService.getBooksByStudentId(this.studentID).size());i++)
       {
             SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
             String date=sdf.format( libraryService. getBooksByStudentId(this.studentID).get(i).getStartDate());
             studentLibraryTable stu = new studentLibraryTable( libraryService. getBooksByStudentId(this.studentID).get(i).getBookName(),
                     libraryService. getBooksByStudentId(this.studentID).get(i).getBookId(),date);

           bookLists.add(stu);
           return bookLists;
         }




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

    public void searchBooks(ActionEvent actionEvent) {

       // LibraryService lib = new LibraryService();
        //

    }

    public void returnTab(Event event) {

        this.showBooksTable(this.getBooksData());
        bookLists.remove(2,5);

        int end=libraryService. getBooksByStudentId(this.studentID).size()*2-1;
        int start=libraryService. getBooksByStudentId(this.studentID).size()-1;
        bookLists.remove(start,end);
        studentBookTable.refresh();
    }

    public void getStudentID( int id)
    {
        studentID=id;
    }
    public void show(int index)
    {
        bookLists.remove(index);
        studentBookTable.refresh();

    }



}
