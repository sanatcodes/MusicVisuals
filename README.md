# Music Visualiser Project

Name: Sanat Thukral

Student Number: D18129674

### Link to the projects YT Video 
[hyperlink](https://youtu.be/ZHcH4J0SshU)

## Instructions
- Fork this repository and use it a starter project for your assignment
- Create a new package named your student number and put all your code in this package.
- You should start by creating a subclass of ie.tudublin.Visual
- There is an example visualiser called MyVisual in the example package
- Check out the WaveForm and AudioBandsVisual for examples of how to call the Processing functions from other classes that are not subclasses of PApplet

# Description of the assignment
In this assigment have made 5 distinct visual art pieces which have been synced to music and compliment it creating a coherent and interactive experience for viewers. One of my aspirations for the assigment was to create variety in my visuals to showcase diversity and a unique perspective to shapes and abstract art. However, all visuals are cohesively connected through the music making it an interesting visual experience which is culminated through the power of code.

I'll explain my thoughtprocess and insipration for all of the visuals below wiht pictures for refference

##Visual 1: ![Visual 1 ](https://user-images.githubusercontent.com/51191924/117230589-55164080-ae15-11eb-9b77-22583c247a60.png)

##Visual 2:![Visual 2](https://user-images.githubusercontent.com/51191924/117230595-5b0c2180-ae15-11eb-9357-06ad22e64c63.png)


##Visual 3:![Visual 3](https://user-images.githubusercontent.com/51191924/117230608-619a9900-ae15-11eb-9930-84d09c5a2d37.png)


##Visual 4:![Visual 4](https://user-images.githubusercontent.com/51191924/117230605-5f383f00-ae15-11eb-8fa1-8acd4f871a6f.png)


##Visual 5:![Visual 5](https://user-images.githubusercontent.com/51191924/117230616-64958980-ae15-11eb-972e-45b6f4179d4f.png)




# Instructions

Step 1: is to press compile using F5 on VS code

Step 2: Press the space bar to play the music

Step 3: Press buttons from 0 - 4 to cycle through different visuals

Step 4: Hover mouse left to right and right to left in last 2 visuals for a camera pan effect to see them move in 3d 

That's it!

# How it works

There are 6 files which house all of the code necessary for the project to work.I'll list the files below and explain their functions below:

Main.java -> this houses the code to actually run the processing sketch and launch it. That is it's only role it houses the main function. Pretty simple standard stuff!

Visual.java -> This file extends the PApplet Library along with containing instances of the Minim library. It also contains boilerplate methods for calculating amplitude, buffer size, frequency bands and other useful methods that I can choose to use in any of my visuals. It also contains accessor methods to all of the methods above and more.

MyVisual.java -> This file inherits Visual the file mentioned above and houses core processing methods such as Setup, Setting and Draw. Instead of adding these methods in all of the files that we make for visuals we can just those files in this central methods. This is an example displaying the power of abstraction and inheritance in action.

VisualException.java

Experiment.java -> This is the file that actually has code for the visuals that I created which are seprated through a switch case and instance of the MyVisual class is also passed in this class to give it access to the PApplet library.

Planet.java -> This class is created to support one of my Visuals and it also inherits myVisuals in order to access methods from the PApplet library and it is instanciated in the Expirment class where it is being used to create visuals.

# What I am most proud of in the assignment

I have gained a lot of knowledge through this project including solidifying my understanding and knowldge of core principles of OOP. Below I have menitoned somethings that I am most proud of being able to accomplish through this assigment.

## Understanding the correct use of git
When I started this project I knew in theory how to use git and most basic functionality, but I didn't see it as something important that I would use if I had the option not to. However, after working on something at this scale and complex, I understood the praise behind the use of this magnificent version control software that is the industry standard. I also coded this project using two different machines so github became an indespensible tool and it allowed me to save my progress every step of the way and allowed me to complete this project in an organised and constructive manner.

I also consulted this post [hyperlink](https://chris.beams.io/posts/git-commit/) which helped me understand why is it important to write good informatinve git messages so understand the pourposed behind every commit and what I have accomplished in that version.

## Learning about Music and art 

I never really saw myself as an artistic or music oriented person I have never really been attracted towards learning the intricacies behind the beats of a song or the color in a fine-art piece. However, after spending a lot of time listening to different kinds of music and watching a lot of digital art, I can see behind the filters into the details and really observe what makes them beautiful and worth the time and effort people put into making them. In short making this project made me see the culture behind art and music and helped me appreciate it. I scavaged spotify and youtube looking at processing tutorials and songs that would fit the visuals I was trying to make.

## Increased understanding of OOP principals 

We did learn about all OOP principles in first semester with Bianca and in my openion at the time I had understood them in concept. However, I couldn't really see their application in practice as it just seemed like extra effort and unecessary. The reason was because we were only making simple things in labs that didn't require the use of encapsulation or polymorphism. However, with this project and the YASC game for that matter I could really see why OOP shines in bigger prjects where the techniques taught can potentially save thousands of lines of code. This project helped solidify my understanding of inheritance, encapsulation, abstraction and polymorphism through practice.

## Working in 3D 



# Markdown Tutorial

This is *emphasis*

This is a bulleted list

- Item
- Item

This is a numbered list

1. Item
1. Item

This is a [hyperlink](http://bryanduggan.org)

# Headings
## Headings
#### Headings
##### Headings

This is code:

```Java
public void render()
{
	ui.noFill();
	ui.stroke(255);
	ui.rect(x, y, width, height);
	ui.textAlign(PApplet.CENTER, PApplet.CENTER);
	ui.text(text, x + width * 0.5f, y + height * 0.5f);
}
```

So is this without specifying the language:

```
public void render()
{
	ui.noFill();
	ui.stroke(255);
	ui.rect(x, y, width, height);
	ui.textAlign(PApplet.CENTER, PApplet.CENTER);
	ui.text(text, x + width * 0.5f, y + height * 0.5f);
}
```

This is an image using a relative URL:

![An image](images/p8.png)

This is an image using an absolute URL:

![A different image](https://bryanduggandotorg.files.wordpress.com/2019/02/infinite-forms-00045.png?w=595&h=&zoom=2)

This is a youtube video:

[![YouTube](http://img.youtube.com/vi/J2kHSSFA4NU/0.jpg)](https://www.youtube.com/watch?v=J2kHSSFA4NU)

This is a table:

| Heading 1 | Heading 2 |
|-----------|-----------|
|Some stuff | Some more stuff in this column |
|Some stuff | Some more stuff in this column |
|Some stuff | Some more stuff in this column |
|Some stuff | Some more stuff in this column |

