package com.myfirstapp.youmna.restaurantmenue

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.food_ticket.view.*

class MainActivity : AppCompatActivity() {
var listfood=ArrayList<Food>()
    var adapter:foodAdapter?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //load food
        listfood.add(Food("Nescafee","NESCAFÉ CLASSIC comes from 100% pure, high quality coffee beans. It is made with Exclusive Pure Coffee Capture, for a pure coffee aroma and taste with every sip",R.drawable.nescafee))
        listfood.add(Food("coffee","Coffee is darkly colored, bitter, slightly acidic and has a stimulating effect in humans, primarily due to its caffeine content. It is one of the most popular drinks in the world, and it can be prepared and presented in a variety of ways (e.g., espresso, French press, café latte)",R.drawable.coffee))
        listfood.add(Food("poteto","perennial plant in the family Solanaceae which is grown for its edible tubers. The potato plant has a branched stem and alternately arranged leaves consisting of leaflets which are both of unequal size ",R.drawable.poteto))
        listfood.add(Food("strawberry","Strawberry fruit are small, bright red cone (sometimes with a pinkish tinge) berries, densely covered with small stones, with juicy red pulp, has a sweet taste and characteristic aroma. Most often strawberry gets «from the ship to the ball,» — that is, from the garden straight to the table",R.drawable.strawberry))
        listfood.add(Food("suger"," A sweet crystalline or powdered substance, white when pure, consisting of sucrose obtained mainly from sugarcane and sugar beets and used in many foods, drinks, ",R.drawable.suger))
        listfood.add(Food("honey","Honey is a sweet, viscous food substance produced by bees and some related insects. Bees produce honey from the sugary secretions of plants (floral nectar) or from secretions of other insects (such as honeydew), by regurgitation, enzymatic activity, and water evaporation",R.drawable.honey))

adapter=foodAdapter(this,listfood)

gvfood.adapter=adapter



    }



    // for load the data on GridView i want to BaseAdapterClass
    class foodAdapter:BaseAdapter{
        var listfood=ArrayList<Food>()
        var context:Context?=null
        constructor(
            context: Context,
            listfood:ArrayList<Food>

        ):super(){
            this.context=context
            this.listfood=listfood
        }
        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            var food=listfood[position]
            var inflator=context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            var foodview=inflator.inflate(R.layout.food_ticket,null)
            foodview.ivfood.setImageResource(food.image!!)
            foodview.ivfood.setOnClickListener{

                val intent=Intent(context,Fooddetails::class.java)
                intent.putExtra("name",food.name!!)
                intent.putExtra("des",food.des!!)
                intent.putExtra("image",food.image!!)
                context!!.startActivities(arrayOf(intent))
            }
            foodview.textView.text=food.name!!
            return foodview

        }

        override fun getItem(position: Int): Any {
            return listfood[position]
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        override fun getCount(): Int {
            return listfood.size
        }
    }
}
