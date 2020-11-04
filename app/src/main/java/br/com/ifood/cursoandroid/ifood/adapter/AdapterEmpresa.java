package br.com.ifood.cursoandroid.ifood.adapter;

import android.annotation.SuppressLint;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.squareup.picasso.Picasso;

import java.util.List;

import br.com.ifood.cursoandroid.ifood.R;
import br.com.ifood.cursoandroid.ifood.model.Empresa;



public class AdapterEmpresa extends RecyclerView.Adapter<AdapterEmpresa.MyViewHolder> {

    private List<Empresa> empresas;

    public AdapterEmpresa(List<Empresa> empresas) {
        this.empresas = empresas;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View itemLista = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_empresa, parent, false);
        return new MyViewHolder(itemLista);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int i) {
        Empresa empresa = empresas.get(i);
        holder.nomeEmpresa.setText(empresa.getNome());
        holder.categoria.setText(empresa.getCategoria() + " - ");
        holder.tempo.setText(empresa.getTempo() + " Min");
        holder.entrega.setText("R$ " + empresa.getPrecoEntrega().toString());

        //Carregar imagem
        String urlImagem = empresa.getUrlImagem();
        Log.i("teste", urlImagem);
        //Picasso.get().load(urlImagem).into(holder.imagemEmpresa);
        //Picasso.get().load( urlImagem ).into( holder.imagemEmpresa );
        Glide.with(holder.itemView).load(urlImagem).into(holder.imagemEmpresa);

    }

    @Override
    public int getItemCount() {
        return empresas.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView imagemEmpresa;
        TextView nomeEmpresa;
        TextView categoria;
        TextView tempo;
        TextView entrega;

        public MyViewHolder(View itemView) {
            super(itemView);

            nomeEmpresa = itemView.findViewById(R.id.textNomeEmpresa);
            categoria = itemView.findViewById(R.id.textCategoriaEmpresa);
            tempo = itemView.findViewById(R.id.textTempoEmpresa);
            entrega = itemView.findViewById(R.id.textEntregaEmpresa);
            imagemEmpresa = itemView.findViewById(R.id.imagemEmpresa);

        }
    }
}
