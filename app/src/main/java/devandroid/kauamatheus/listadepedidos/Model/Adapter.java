package devandroid.kauamatheus.listadepedidos.Model;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import devandroid.kauamatheus.listadepedidos.R;
import devandroid.kauamatheus.listadepedidos.View.MainActivity;

public class Adapter extends RecyclerView.Adapter<Adapter.RecyclerTesteViewHolder> {

    public static Interface.ClickRecyclerView_Interface clickRecyclerViewInterface;
    Context mctx;
    private List<Item> mList;

    public Adapter(Context ctx, List<Item> list, Interface.ClickRecyclerView_Interface clickRecyclerViewInterface) {
        this.mctx = ctx;
        this.mList = list;
        this.clickRecyclerViewInterface = clickRecyclerViewInterface;
    }

    @Override
    public RecyclerTesteViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.activity_order_item, viewGroup, false);
        return new RecyclerTesteViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(RecyclerTesteViewHolder viewHolder, int i) {
        Item item = mList.get(i);

        viewHolder.viewNome.setText(item.getNome());
        viewHolder.viewQntd.setText(item.getQntd());

        Button bt_delete = viewHolder.button;
        bt_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                
                deleteContact();
                notifyDataSetChanged();


                //                Toast.makeText(MainActivity.this, " Delete ", Toast.LENGTH_SHORT).show();




            }
        });


    }

    public void deleteContact( ) {
        if (mList.size() > 0) {
            mList.remove(0);
//            mList(new ArrayList(mList)); // DiffUtil takes care of the check
        }
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }


    protected class RecyclerTesteViewHolder extends RecyclerView.ViewHolder {

        protected TextView viewNome;
        protected TextView viewQntd;
        protected Button button;

        public RecyclerTesteViewHolder(final View itemView) {
            super(itemView);

            viewNome = (TextView) itemView.findViewById(R.id.TextViewNome);
            viewQntd = (TextView) itemView.findViewById(R.id.textViewQnt);
            button = (Button) itemView.findViewById(R.id.button);


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    clickRecyclerViewInterface.onCustomClick(mList.get(getLayoutPosition()));

                }
            });
        }
    }
}
