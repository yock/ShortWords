package com.yocksoft.shortwords;

import com.yocksoft.shortwords.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.ListView;

public class ShortWords extends Activity {
	private ListView letterListView;
	private ListView wordListView;
	private ArrayAdapter<String> letterListAdapter;
	private ArrayAdapter<String> wordListAdapter;
	private String[] wordList;
	private String filterValue = null;
	private static final String[] LETTER_LIST = { "A", "B", "C", "D", "E", "F",
			"G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S",
			"T", "U", "V", "W", "X", "Y", "Z" };

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		wordList = getResources().getStringArray(R.array.twl98);

		letterListView = (ListView) findViewById(R.id.letterlistview);
		wordListView = (ListView) findViewById(R.id.wordlistview);

		letterListAdapter = new ArrayAdapter<String>(this, R.layout.rowlayout,
				R.id.tileletter, LETTER_LIST);
		letterListView.setAdapter(letterListAdapter);

		wordListAdapter = new ArrayAdapter<String>(this, R.layout.wordview,
				wordList);
		wordListView.setAdapter(wordListAdapter);

		letterListView.setOnItemClickListener(new OnItemClickListener() {

			public void onItemClick(AdapterView<?> adapterView, View view,
					int position, long id) {
				int idInt = new Long(id).intValue();
				String selectedValue = LETTER_LIST[(int) idInt];
				Filter filter = wordListAdapter.getFilter();
				if (selectedValue.equals(filterValue)) {
					filterValue = null;
					filter.filter(null);
				} else {
					filterValue = selectedValue;
					filter.filter(filterValue);
				}
			}

		});

	}
}