/**
 * 
 */
package neu.edu.Models;
import java.time.LocalDate;
import java.util.List;

/**
 * @author Janvi Modi
 *
 */
public class NotesEntity {
	
	public int id;

	public  String NoteTitle="";
	public  String NoticeBody="";

	public String CreatedBy="";
	
    public List<ReplyNotesEntity> listOfReply; 

	/**
	 * 
	 */
    public NotesEntity(int Id,String notetitle , String noticebody , String createdby) {
		// TODO Auto-generated constructor stub
	
		this.id=Id;
		
		this.NoteTitle=notetitle;
		this.NoticeBody = noticebody;
		this.CreatedBy = createdby;
	
	}
	public NotesEntity(int Id,String notetitle , String noticebody , String createdby,List<ReplyNotesEntity> ListOfReply) {
		// TODO Auto-generated constructor stub
	
		this.id=Id;
		
		this.NoteTitle=notetitle;
		this.NoticeBody = noticebody;
		this.CreatedBy = createdby;
		this.listOfReply=ListOfReply;
	}
	

	public void SetNoticeTitle(String noticetitle) {
		 this.NoteTitle = noticetitle;
	}
	public String getNoteTitle() {
		return this.NoteTitle;
	}


	public void SetNoteBody(String noticebody) {
		this.NoticeBody = noticebody;
	}
	public String getNoteBody() {
		return this.NoticeBody;
	}
	
	public void SetCreatedBy(String Createdy) {
		this.CreatedBy = Createdy;
	}
	public String getCreatedBy() {
		return this.CreatedBy;
	}
	
//	public String GetNoticeTitle(){return this.NoteTitle;}
	
	//public String GetNoticeBody(){return this.NoticeBody;}

	//public String createdBy(){return this.CreatedBy;}
	
	//public LocalDate DateTime() { LocalDate myObj = LocalDate.now(); return myObj; }

	public String ToString() {
		String note  = this.NoteTitle+""+this.NoticeBody+"";
		
		return note;
	}
	
	
 

}
