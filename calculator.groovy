import groovy.swing.SwingBuilder

import java.awt.FlowLayout
import java.awt.BorderLayout as BL
import static javax.swing.JFrame.EXIT_ON_CLOSE

def app = new SwingBuilder().edt {
	lookAndFeel 'nimbus'
    frame(title: 'Calculator', 
    	size: [300, 100], 
    	location: [500,250],
    	show: true,
    	defaultCloseOperation: EXIT_ON_CLOSE) {
    panel(){
    	flowLayout()
	    textField(id: 'left', columns: 5, text: "0.0")
	    comboBox(id: 'operator', items: ['+','-','x', '/'])
	    textField(id: 'right', columns: 5, text: "0.0")
	    result = label(text: "= 0.0")
	    constraints: BL.NORTH
	}
    button(text: "Calculate!",
    actionPerformed: {
    	try{
	   	a = Double.parseDouble(left.text)
		b = Double.parseDouble(right.text)
		
	   	if(operator.selectedItem=='+')
	   		ans = (a+b).trunc(3)
	   	else if(operator.selectedItem=='-')
	   		ans = (a-b).trunc(3)
	   	else if(operator.selectedItem=='x')
	   		ans = (a*b).trunc(3)	
	   	else
	   		ans = (a/b).trunc(3)
	   	result.text="= ${ans}"
	   }
	   catch (NumberFormatException e){
			result.text="Numbers only, please!"
	   } 
   	}, 
   	constraints: BL.SOUTH)
  }
}