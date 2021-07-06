# DreamTeamEuro

Euro 2020 Fantasy android application

## Specifications
https://hackmd.io/@elmedins/HJlxLts5u

## Description

Splash <br><br>
Android Splash Screen is the first screen visible to the user when the application's launched. In this case, it's a simple 3 second animation of the official logo of the Euro 2020 Championship that proceeds to the Home screen of the app. <br><br>
<img src="https://user-images.githubusercontent.com/53277964/124465861-350fe880-dd96-11eb-9e87-05176889d181.jpg" width="148">

Home <br><br>
The Home screen is fairly simple. It has a list of all countries taking part in the Euro 2020 Championship which are located in an Android Spinner where the user can easily select a country. Bellow the Spinner the "View Squad" button is located. It has an "onClick" listener that takes the selected country name, gets the selected countries Id which is located in the "country name to Id" hash map for efficiency and passes them via the "Safe Args plugin" to the next fragment using the "nav controller". The "nav controller" is basically a set of directions in the app from one fragment to the next one. The app proceeds to the List fragment. <br><br>
<img src="https://user-images.githubusercontent.com/53277964/124466032-730d0c80-dd96-11eb-9c5d-c4c3063f50df.jpg" width="148">
<img src="https://user-images.githubusercontent.com/53277964/124466087-87e9a000-dd96-11eb-9985-9732caae18e3.jpg" width="148">

List <br><br>
List fragment does the dirty work. In it, we connect to the internet using the Retrofit 2 library with Rapid API and display the fetched data in the Android RecyclerView. Connection to the internet could not be made without including the Android Internet permission in the AndroidManifest file. Permissions help support user privacy by protecting access to Restricted data, such as system state and a user's contact information, and Restricted actions, such as connecting to a paired device and recording audio. The Rapid API is an online service of mostly free APIs. In this project, we used the Sofascore API from Rapid API to get all the players from their respective countries to take part in the Euro 2020 Championship. <br>
We use the passed arguments from the Home fragment, "teamName" to display the selected teams/countries name and "teamId" which we use to dynamically send a get request to the Sofascore Rapid API service to get all the players from that county and some additional data regarding the players. For that to work, firstly we need a Kotlin interpretation of the received JSON response, which we acquired using the "JSON to Kotlin data class converter" plugin. It interprets the JSON response to OOP style and through several classes converts it to Kotlin. Secondly, we need a Retrofit instance object (singleton) to communicate with the Sofascore API. In it, we store a Retrofit Val (const value) which uses "Retrofit Builder" to communicate with Sofascore base URI and we store the Sofascore API instance.  They both are lazily initialized which means they are only initialized once when in use or never if not used because the initialization process for them is expensive in terms of performance. We also need an Android Repository to store the received data from the Retrofit instance singleton and to pass it to the Android ViewModel. The ViewModel uses the Repository to fetch the data because the Repository knows where to ask to get the data. <br>
The ViewModel is used to take off the load from the List fragment by dealing with the incoming data that needs to be displayed in the List fragment view. We use RecyclerView to display received data. An Android RcyclerView is the ViewGroup that contains the views corresponding to the received data. The data is displayed usually in some sort of a compact list as it is in this case. Every list item represents a player from the selected country in which we can see the player's data such as the player's shirt number, his name, and his market value. For the RecyclerView to work we need an adapter in which we pass the requested player list. <br>
For the RecyclerView to work we need an adapter in which we pass the requested player list. User can sort the players by their market value in descending or ascending order. The adapter deals with the received data and decides what to display. In it, we made a Click Listener interface which is later implemented in the List fragment to forward us to the next fragment in which we pass player data as arguments based on the List item view we clicked in the RecyclerView. <br><br>
<img src="https://user-images.githubusercontent.com/53277964/124466237-b9626b80-dd96-11eb-9ecd-2ba4fcd2a8da.jpg" width="148">
<img src="https://user-images.githubusercontent.com/53277964/124466278-c8491e00-dd96-11eb-9750-25233d1dfa45.jpg" width="148">

About <br><br>
This fragment is used to display more data for the selected player. The fragment has two different XML layout files, one for portrait, one for landscape mode. The fragment fetches data from the argument passed from the List fragment via Safe Args plugin. It then formats the data in a specific way using the MyFormat helper class in which we have a couple of companion object functions which are like static functions in Java. That means we don't have to instantiate the class to use its methods. The fragment has a Floating Action Button that when clicked saves the player to the Room database and navigates to the next fragment where all the saved players are displayed in a RecyclerView including the newly saved. <br><br>
<img src="https://user-images.githubusercontent.com/53277964/124466394-eca4fa80-dd96-11eb-8da1-1c4307a1b512.jpg" width="148">
<img src="https://user-images.githubusercontent.com/53277964/124466514-034b5180-dd97-11eb-9f55-ac591433d1e8.jpg" width="348">

Data <br><br>
In this project we use the Room base.
The base room is part of the components of android architecture. The room consists of 3 basic components.<br>
   1.Database<br>
   2.Entity<br>
   3.DAO<br>

   Database<br>
In order to create a database in Kotlin, we need to include dependencies, create a class and mark the basic data (@Database) and also give the names of the tables that we will use in the project.


   Entity<br>
A data class that represents a class of data in a database. It is marked with the keywords @Entitiy. The fields in the class correspond to the columns in the table. It consists of at least one field that must be the primary key.

   DAO<br>
Within DAO it contains methods that use db operations.
We can use 4 notes: (Insert, update, delete, query) <br><br>
<img src="https://user-images.githubusercontent.com/53277964/124466683-237b1080-dd97-11eb-9094-cdfb9aac5bc4.jpg" width="148">
<img src="https://user-images.githubusercontent.com/53277964/124466789-43aacf80-dd97-11eb-97b9-6206371ed0ef.jpg" width="148">
<img src="https://user-images.githubusercontent.com/53277964/124466836-545b4580-dd97-11eb-9340-3d88040f7cee.jpg" width="148">
<img src="https://user-images.githubusercontent.com/53277964/124466898-6a690600-dd97-11eb-9f19-bc49a88d374e.jpg" width="148">
<br><br>
When we save a player, it takes us to the next fragment where the players selected by the user are housed.
In the app bar we have the option to share or delete the list of added players.


## Tech used

<ul>
  <li>
    <a href="https://kotlinlang.org/">Kotlin</a>
  </li>
  <li>
    <a href="https://plugins.jetbrains.com/plugin/9960-json-to-kotlin-class-jsontokotlinclass-">JSON to Kotlin Data Class</a>
  </li>
  <li>
    <a href="https://square.github.io/retrofit/">Retrofit</a>
  </li>
  <li>
    <a href="https://developer.android.com/jetpack/androidx/releases/room">Room database</a>
  </li>
  <li>
    <a href="https://rapidapi.com/apidojo/api/sofascore/">Sofascore Rapid API</a>
  </li>
</ul>




## How to install

If you have android studio installed on your computer, download the project from <a href="https://github.com/tala-coder/DreamTeamEuro">this</a> repository, open it in adroid studio, connect your android phone to the computer via usb cable, in developer options on your pohne enable usb debugging, in the android studio AVD manager select your device and click run. If you don't have android studio, follow <a href="https://www.techsupportofmn.com/how-to-use-your-computer-to-install-apps-on-your-android-device">these instructions</a>.<br>
If your on mobile phone follow this <a href="https://easyupload.io/mxp3m5">link</a>

