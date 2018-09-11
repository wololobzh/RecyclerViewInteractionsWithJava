package fr.acos.recyclerviewinteractionswithjava;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;
import java.util.ArrayList;
import fr.acos.recyclerviewinteractionswithjava.adapter.MyAdapter;

/**
 *  Activité principale.
 */
public class MainActivity extends AppCompatActivity implements MyAdapter.OnClicSurUnItem<String>
{
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    /**
     * Callback appelé à la création de l'activité.
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Récupéraction d'un objet représentant le Recycler View
        mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);

        // Permet d’optimiser le chargement dans le cas ou le recycler view ne change pas de taille.
        mRecyclerView.setHasFixedSize(true);

        // Utilisation du linear layout manager
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        // bouchon
        ArrayList<String> liste = new ArrayList<>();
        liste.add("Bleu");
        liste.add("Blanc");
        liste.add("Rouge");

        //Création de l'adapteur
        mAdapter = new MyAdapter(liste,this);

        //Lie l’adapter au recycler view
        mRecyclerView.setAdapter(mAdapter);
    }


    /**
     * Fonction permettant de définir l'action à réaliser au moment d'un clic sur un élément.
     *
     * @param info objet affiché dans l'item sur lequel a cliqué l'utilisateur
     */
    @Override
    public void onInteraction(String info)
    {
        Toast.makeText(this, info, Toast.LENGTH_SHORT).show();
    }
}
