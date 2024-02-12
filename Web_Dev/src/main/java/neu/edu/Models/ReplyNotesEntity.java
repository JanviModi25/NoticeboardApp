package neu.edu.Models;

import java.util.List;

public class ReplyNotesEntity {
	
	public int id ;
    public int notesid;
    public String reply;
    public String CreatedBy;

	public ReplyNotesEntity(int id,int NotesId,String Reply,String createdby) {
		// TODO Auto-generated constructor stub
		super();
		this.id= id;
		this.notesid=NotesId;
		this.reply = Reply;
		this.CreatedBy=createdby;
		
	}

	

}
