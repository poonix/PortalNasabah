package teknologi.azha.portaldebitur.ui.adapter;

import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import teknologi.azha.portaldebitur.R;
import teknologi.azha.portaldebitur.ui.listerner.OnItemClickListener;

/**
 * Created by user on 11/2/2017.
 */

public class MenuViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    private OnItemClickListener mListener;

    @BindView(R.id.ll_content)
    public View mContainer;
    @BindView(R.id.tv_menu)
    public TextView tvMenu;
    @Nullable
    @BindView(R.id.iv_icon)
    public ImageView ivIcon;


    public MenuViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
        itemView.setClickable(true);
        itemView.setOnClickListener(this);
    }

    public void setOnClickListener(OnItemClickListener listener) {
        this.mListener = listener;
    }

    @Override
    public void onClick(View v) {
        if (mListener != null) {
            mListener.onItemClick(itemView, v, getAdapterPosition(), getItemId());
        }
    }
}
