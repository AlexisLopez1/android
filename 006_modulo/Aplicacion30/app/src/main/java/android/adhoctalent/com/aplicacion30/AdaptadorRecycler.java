package android.adhoctalent.com.aplicacion30;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Description:
 * <p>
 * Copyright 2017 AdhocTalent
 * <p>
 * Created by luiscobian on 7/21/17.
 * Edit by ---- on 7/21/17
 */

public class AdaptadorRecycler extends  RecyclerView.Adapter<AdaptadorRecycler.ViewPersonal>
        implements  View.OnClickListener
        {

private List<Personal> lista;

private  View.OnClickListener listener;


public AdaptadorRecycler(Context context) {
        this.lista = BaseDatosPersonal.getLista(context);
        }

@Override
public ViewPersonal onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).
        inflate(R.layout.personal_view,parent,false);
        v.setOnClickListener(this);
        ViewPersonal viewPersonal = new ViewPersonal(v);
        return viewPersonal;
        }

@Override
public void onBindViewHolder(ViewPersonal holder, int position) {

        Personal personal = lista.get(position);
        holder.txtNombre.setText(personal.getNombre());
        holder.txtTelefono.setText(personal.getTelefono());
        }

@Override
public int getItemCount() {
        return lista.size();
        }

public void setOnClickListener(View.OnClickListener listener){
        this.listener = listener;
        }

@Override
public void onClick(View v) {
        if(listener!=null)
        {
        listener.onClick(v);
        }
        }


public static class ViewPersonal extends RecyclerView.ViewHolder{
    TextView txtNombre;
    TextView txtTelefono;

    public ViewPersonal(View itemView)
    {
        super(itemView);
        txtNombre = (TextView) itemView.findViewById(R.id.vistaTxtNombre);
        txtTelefono = (TextView) itemView.findViewById(R.id.vistaTxtTelefono);
    }

}
}