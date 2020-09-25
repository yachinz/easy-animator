In my project, I have a model, two controller and two view.

In this model, I changed the structure of classes to make them more organized.
Thus I deleted the timeline pakage and add a canvas class. 
And I moved the HashMap which stored the name and shape into canvas class. The next layer is IShapeOnChanvas. But I still keeps the shapes and color class.

The relationship of these classes is IAnimationModel - canvas - a shape on canvas;

Now there are fewer methods in my IAnimationModel, 
which are  
setBound, addShape, addAnimation, getAnimationFrame, getTextualAnimation,getBound,  toString.    
 I deleted all other classes as the user don't use them now. 
I couldn't extend my old interface as I added too many methods and they couldn't match the given builder methods. This caused a
big problem. So I wrote a new Interface, a new Class and new test.

  
After initialize the model, data are stored in Canvas and IShapeOnChanvas in the form of LinkedHashMap. LinkedHashMap can keep the order of keys, which is important.    
 In IShapeOnChanvas, the HashMap data is like<time, double[]>.   
In array double[], it saves {positionx, position y, scale x, scale y, r, g, b}  
When user want to get animation view or get textual view, controller will call different method in model. 
The textualView method and animation method are independent of each other. 
When user call the method, it will get the data from the Canvas and IShapeOnChanvas and then compute the return value;
And another advantage is if I need to add a remove function like remove a shape , which I actually did in hw9, I can just remove the shape from canvas HashMap. And the textual view, animation view will automatically change when being called. 

This is my new model structure:

##cs5004.animator.model
IAnimationModel(Interface);  
IAnimationModelImpl(class); *Interact with controller*  
shapes(package); *Some shapes, rectangle, oval*  
canvas(package);
  
##cs5004.animator.model.canvas  
ICanvas(Interface);  
Canvas(Class); *Interact with IAnimationModelImpl*  
IShapeOnChanvas(Interface);  
IShapeOnChanvasImpl(Class); "Interact with Canvas"  
Position2D(Interface);  
Position2DImpl(class);  
  

In controller, there is an interface and two class that implement it.  
##cs5004.animator.controller  
IController(Interface);  
AnimationController(class); "Interact with model and animation view"  
TextViewController(class); "Interact with model and textual view"  


In view, there are two kind of view and interface and some shapes classes.  
I choose Graphics2D to draw rectangle and oval, this could make the animation more smooth since the input is double.
##cs5004.animator.view
IAnimationView(Interface);  
AnimationView(class); "Interact with AnimationController and Drawing panel"  
DrawingPanel(class); "Draw all shapes"  
Shape(Interface);  
AbstractViewShape(Abs class);  
Oval(class);
Rectangle(class);  
  
ITextView(Interface);   
TextView(class); "Interact with TextViewController"  

The reason that I wrote two kinds of shape is because I don't want to share 
classes between model and view.  
I also wrote a util class to determine if the args is illegal.


















