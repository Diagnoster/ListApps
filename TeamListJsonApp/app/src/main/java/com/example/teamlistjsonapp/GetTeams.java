package com.example.teamlistjsonapp;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GetTeams extends AsyncTask<String, Void, Void> {

    private ProgressDialog progressDialog;
    private Context context;
    private ListView listView;
    ArrayList<HashMap<String, String>> teamList;

    public GetTeams(ProgressDialog progressDialog, ListView listVie, Context context) {
        this.progressDialog = progressDialog;
        this.listView = listView;
        this.context = context;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        progressDialog.setMessage("Aguarde...");
        progressDialog.setCancelable(false);
        progressDialog.show();
    }

    @Override
    protected Void doInBackground(String... strings) {
        HttpHandler sh = new HttpHandler();
        teamList = new ArrayList<>();

        //request and take response
        String jsonStr = sh.makeServiceCall(strings[0]);
        if (jsonStr != null) {
            try {
                JSONObject jsonObject = new JSONObject(jsonStr);
                JSONArray teams = jsonObject.getJSONArray("times");

                for(int i = 0; i < teams.length(); i++) {
                    JSONObject object = teams.getJSONObject(i);
                    String id = object.getString("id");
                    String name = object.getString("nome");
                    String city = object.getString("cidade");
                    String series = object.getString("serie");
                    HashMap<String, String> team = new HashMap<>();
                    team.put("id", id);
                    team.put("nome", id);
                    team.put("cidade", id);
                    team.put("serie", id);
                    System.out.println("CIDADE = " + city);
                    teamList.add(team);
                }
            } catch (final JSONException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        if(progressDialog.isShowing()) {
            progressDialog.dismiss();
        }
        ListAdapter adapter = new SimpleAdapter(
                context,
                teamList,
                R.layout.list_items,
                new String[]{"name", "city", "series"},
                new int[]{R.id.name, R.id.city, R.id.series}
        );
        listView.setAdapter(adapter);
    }
}
