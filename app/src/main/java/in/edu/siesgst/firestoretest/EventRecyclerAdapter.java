package in.edu.siesgst.firestoretest;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by aditya on 4/2/18.
 */

public class EventRecyclerAdapter extends RecyclerView.Adapter<EventRecyclerAdapter.ViewHolder> {

    List<Event> eventList;
    Context context;

    public EventRecyclerAdapter(List<Event> eventList, Context context) {
        this.eventList = eventList;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View rootView = LayoutInflater.from(parent.getContext()).inflate(R.layout.event_layout, parent, false);

        return new ViewHolder(rootView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.eventPrice.setText("$"+eventList.get(position).getPrice());
        holder.eventName.setText(eventList.get(position).getEvent_name());

    }

    @Override
    public int getItemCount() {
        return eventList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView eventName,eventPrice;
        public ViewHolder(View itemView) {
            super(itemView);
            eventName=(TextView)itemView.findViewById(R.id.event_name);
            eventPrice=(TextView)itemView.findViewById(R.id.event_price);
        }
    }
}
