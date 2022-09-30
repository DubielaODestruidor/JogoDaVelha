package br.com.jogodavelha;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class recyclerAdapter extends RecyclerView.Adapter<recyclerAdapter.MyViewHolder> {
    private ArrayList<LorePiece> lorePieces;
    public recyclerAdapter(ArrayList<LorePiece> lorePieces) {
        this.lorePieces = lorePieces;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_items, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        String name = lorePieces.get(position).getText();
        holder.loreTxt.setText(name);
    }

    @Override
    public int getItemCount() {
        return lorePieces.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        private TextView loreTxt;
        public MyViewHolder(final View view) {
            super(view);
            loreTxt = view.findViewById(R.id.lorePiece);
        }

}



}
