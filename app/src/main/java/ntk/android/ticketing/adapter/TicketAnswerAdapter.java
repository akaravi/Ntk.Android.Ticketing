package ntk.android.ticketing.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import butterknife.BindViews;
import butterknife.ButterKnife;
import ntk.android.base.entitymodel.ticketing.TicketingAnswerModel;
import ntk.android.base.utill.AppUtill;
import ntk.android.base.utill.FontManager;
import ntk.android.ticketing.R;

public class TicketAnswerAdapter extends RecyclerView.Adapter<TicketAnswerAdapter.ViewHolder> {

    private List<TicketingAnswerModel> arrayList;
    private Context context;

    public TicketAnswerAdapter(Context context, List<TicketingAnswerModel> arrayList) {
        this.arrayList = arrayList;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row_recycler_ticket_answer, viewGroup, false);
        return new ViewHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        holder.Lbls.get(0).setText(Html.fromHtml(arrayList.get(position).htmlBody
                .replace("<p>", "")
                .replace("</p>", "")));
        holder.Lbls.get(1).setText(AppUtill.GregorianToPersian(arrayList.get(position).CreatedDate.toString()) + "");//todo seem to be string maybe bug
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindViews({R.id.lblTypeRecyclerTicketAnswer,
                R.id.lblDateRecyclerTicketAnswer})
        List<TextView> Lbls;

        public ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
            Lbls.get(0).setTypeface(FontManager.GetTypeface(context, FontManager.IranSans));
            Lbls.get(1).setTypeface(FontManager.GetTypeface(context, FontManager.IranSans));
        }
    }
}
