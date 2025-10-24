package com.example.responsi1mobileh1d023088.ui
import android.graphics.Color
import android.view.ViewGroup
import android.widget.AdapterView
import androidx.recyclerview.widget.RecyclerView
import com.example.responsi1mobileh1d023088.data.model.entity.Player
import com.example.responsi1mobileh1d023088.databinding.ListPlayerBinding

class PlayerAdapter (
    var players: List<Player>,
    private val onClick: OnPlayerClickListener
) : RecyclerView.Adapter<PlayerAdapter.PlayerViewHolder>(){
    inner class PlayerViewHolder(val binding: ListPlayerBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): PlayerAdapter.PlayerViewHolder {
        val binding = ListPlayerBinding.inflate(
            android.view.LayoutInflater.from(parent.context),
            parent,
            false
        )
        return PlayerViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PlayerViewHolder, position: Int) {
        val player = players[position]
        holder.binding.tvName.text = player.name
        holder.binding.tvCountry.text = player.nationality

        val color = when (player.position.lowercase()) {
            "goalkeeper" -> Color.YELLOW
            "defence" -> Color.BLUE
            "midfield" -> Color.GREEN
            "centre-forward" -> Color.RED

            else -> Color.GRAY
        }
        holder.binding.cardPlayer.setBackgroundColor(color)

        holder.binding.root.setOnClickListener {
            onClick.onPlayerClick(player)
        }
    }

    override fun getItemCount(): Int = players.size

    interface OnPlayerClickListener {
        fun onPlayerClick(player: Player)
    }

}
