package in.edu.siesgst.firestoretest;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    FirebaseFirestore db = FirebaseFirestore.getInstance();
    String TAG = "Bumbaclot";


    DocumentReference docRef = FirebaseFirestore.getInstance().document("events/sample-event");
    CollectionReference colRef = FirebaseFirestore.getInstance().collection("events");
    RecyclerView recyclerView;
    EventRecyclerAdapter adapter;

    @Override
    protected void onStart() {
        super.onStart();
        colRef.addSnapshotListener(this,new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(QuerySnapshot documentSnapshots, FirebaseFirestoreException e) {
                List<DocumentSnapshot> documentSnapshotList = documentSnapshots.getDocuments();
                List<Event> eventList = new ArrayList<>();
                for (int i = 0; i < documentSnapshotList.size(); i++) {
                    DocumentSnapshot documentSnapshot = documentSnapshotList.get(i);
                    Event event = documentSnapshot.toObject(Event.class);
                    eventList.add(event);
                    Log.d(TAG, "onEvent=" + event.getEvent_name());
                }

                adapter = new EventRecyclerAdapter(eventList, MainActivity.this);
                adapter.notifyDataSetChanged();

            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.firestore_event_recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));

//        docRef.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
//            @Override
//            public void onSuccess(DocumentSnapshot documentSnapshot) {
//                Event event=documentSnapshot.toObject(Event.class);
//
//                Log.d(TAG,"category="+event.getCategory()+" day="+event.getDay());
//
//            }
//        });

        colRef.get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
            @Override
            public void onSuccess(QuerySnapshot documentSnapshots) {
                Log.d(TAG, "data=" + documentSnapshots.size());

                List<DocumentSnapshot> documentSnapshotList = documentSnapshots.getDocuments();
                List<Event> eventList = new ArrayList<>();
                for (int i = 0; i < documentSnapshotList.size(); i++) {
                    DocumentSnapshot documentSnapshot = documentSnapshotList.get(i);
                    Event event = documentSnapshot.toObject(Event.class);
                    eventList.add(event);
                    Log.d(TAG, "name=" + event.getEvent_name());
                }

                adapter = new EventRecyclerAdapter(eventList, MainActivity.this);
                recyclerView.setAdapter(adapter);


            }
        });

    }
}
