package raha.test.circularfloatingactionmenu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.core.content.res.ResourcesCompat
import com.oguzdev.circularfloatingactionmenu.library.FloatingActionMenu
import com.oguzdev.circularfloatingactionmenu.library.SubActionButton
import raha.test.circularfloatingactionmenu.databinding.ActivityMainBinding

// 1.adding view binding to our awesome project :)
// 2.adding the CircularFloatingActionMenu dependency to build.gradle (Module)
// 3.make the layout ready...
// 4. work on context

class MainActivity : AppCompatActivity() {

    // 1
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // 1
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 4

        // set the main FAB
        val icon = ImageView(this)
        icon.setImageDrawable(ResourcesCompat.getDrawable(resources, R.drawable.ic_add_24, null))
        val floatingActionButton = com.oguzdev.circularfloatingactionmenu.library.FloatingActionButton.Builder(this)
            .setContentView(icon)
            .build()

        // set the menu
        //you have to create icons as many as you need
        //first btn
        val itemBuilderA: SubActionButton.Builder = SubActionButton.Builder(this)
        val itemIconA: ImageView = ImageView(this)
        itemIconA.setImageDrawable(ResourcesCompat.getDrawable(resources, R.drawable.ic_extension_24, null))
        val firstBtn = itemBuilderA.setContentView(itemIconA).build()

        //second btn
        val itemBuilderB: SubActionButton.Builder = SubActionButton.Builder(this)
        val itemIconB: ImageView = ImageView(this)
        itemIconB.setImageDrawable(ResourcesCompat.getDrawable(resources, R.drawable.ic_favorite_24, null))
        val secondBtn = itemBuilderB.setContentView(itemIconB).build()

        //third btn
        val itemBuilderC: SubActionButton.Builder = SubActionButton.Builder(this)
        val itemIconC: ImageView = ImageView(this)
        itemIconC.setImageDrawable(ResourcesCompat.getDrawable(resources, R.drawable.ic_filter_drama_24, null))
        val thirdBtn = itemBuilderC.setContentView(itemIconC).build()

        //changing the size of the menu btns
        firstBtn.layoutParams.apply {
            height = 150
            width = 150
        }
        secondBtn.layoutParams.apply {
            height = 150
            width = 150
        }
        thirdBtn.layoutParams.apply {
            height = 150
            width = 150
        }

        //changing the background of the menu btns
        //I made a drawable resource file named menu_item_bc as my btn background
        firstBtn.setBackgroundResource(R.drawable.menu_item_bc)
        secondBtn.setBackgroundResource(R.drawable.menu_item_bc)
        thirdBtn.setBackgroundResource(R.drawable.menu_item_bc)

        //connect the menu to the FAB
        val actionMenu = FloatingActionMenu.Builder(this)
            .addSubActionView(firstBtn)
            .addSubActionView(secondBtn)
            .addSubActionView(thirdBtn)
            .attachTo(floatingActionButton)
        actionMenu.build()


        //time to work with the buttons
        firstBtn.setOnClickListener {
            binding.materialCardView.setCardBackgroundColor(ResourcesCompat.getColor(resources, R.color.purple_200, null))
        }
        secondBtn.setOnClickListener {
            binding.materialCardView.setCardBackgroundColor(ResourcesCompat.getColor(resources, R.color.purple_500, null))
            binding.txtMain.setTextColor(ResourcesCompat.getColor(resources, R.color.white, null))
        }
        thirdBtn.setOnClickListener {
            binding.materialCardView.setCardBackgroundColor(ResourcesCompat.getColor(resources, R.color.purple_700, null))
            binding.txtMain.setTextColor(ResourcesCompat.getColor(resources, R.color.white, null))
        }

    }

}