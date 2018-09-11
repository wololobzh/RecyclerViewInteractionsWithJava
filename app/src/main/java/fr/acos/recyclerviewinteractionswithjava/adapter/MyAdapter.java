package fr.acos.recyclerviewinteractionswithjava.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;
import fr.acos.recyclerviewinteractionswithjava.R;

/**
 * Cette classe permet de créer les views du recycler view.
 *
 * MyAdapter.ViewHolder est définit à l’intérieur de la classe MyAdapter
 */
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    //Permet de stocker les données à afficher.
    private ArrayList<String> mDataset;

    private OnClicSurUnItem action;

    /**
    * Fournit une référence aux vues pour chaque élément de données
    */
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
    {
        // Chaque élément contient seulement une TextView
        TextView mTextView;

        ViewHolder(View v) {
            super(v);
            mTextView = v.findViewById(R.id.tv_info);
            v.setOnClickListener(this);
        }

        /**
         * Action réalisée lors d'un clic sur un élément du RecyclerView.
         */
        @Override
        public void onClick(View v) {
            action.onInteraction(mDataset.get(ViewHolder.this.getAdapterPosition()));
        }
    }

    /**
     * Interface devant être implémenté par l'activité définissant le RecyclerView
     */
    public interface OnClicSurUnItem<T> {
        void onInteraction(T info);
    }

    /**
    *  Constructeur qui attend les données à afficher en paramètre
    **/
    public MyAdapter(List<String> myDataset, OnClicSurUnItem activite) {
        mDataset = (ArrayList<String>)myDataset;
        action = activite;
    }

    /**
    *  Créé un ViewHolder qui représente le fichier my_text_view.xml
    **/
    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.my_text_view, parent, false);
        return new ViewHolder(v);
    }

    /**
     * Remplie la vue représentant une ligne
     */
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.mTextView.setText(mDataset.get(position));
    }

    /**
     * Retourne le nombre de données à afficher
     *
     * @return le nombre de données à afficher
     */
    @Override
    public int getItemCount() {
        return mDataset.size();
    }
}