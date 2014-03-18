import android.widget.ImageView;

import com.example.echwang.main.IconTextListAdapter;


public class FamilyApplication {
	private String data;
	private int mSelectedIndex;
	private ImageView photoItem;
	private IconTextListAdapter mAdapter;
	
	public int getmSelectedIndex() {
		return mSelectedIndex;
	}

	public void setmSelectedIndex(int mSelectedIndex) {
		this.mSelectedIndex = mSelectedIndex;
	}

	public ImageView getPhotoItem() {
		return photoItem;
	}

	public void setPhotoItem(ImageView photoItem) {
		this.photoItem = photoItem;
	}

	public String getData(){
		return data;
	}
	
	public void setData(String data){
		this.data = data;
	}
	
	public IconTextListAdapter getmAdapter() {
		return mAdapter;
	}

	public void setmAdapter(IconTextListAdapter mAdapter) {
		this.mAdapter = mAdapter;
	}
}
