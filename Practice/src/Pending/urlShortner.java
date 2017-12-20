package Pending;

/* 
 * 8.Design a URL shortening system such as bit.ly
 * 9. Design auto complete feature for a mobile client.
 * 11.Implement a hive udf - for the given string return a score based on the sentiment words found. 
 * (good: 1; average: 0; bad: -1) Ex. good food, bad service = 1 - 1 = 0 
 * 14. How would you design a 1000 story building so that people can efficiently get out of the building 
 * during rush hours(lunch hours). 
 * 19. familiar with web server, load balance, master-slave db, data sharding, caching, denormalizing, 
 * etc.. you are in good shape.
 * 20. how to backup between two servers. 
 * 22. A user logs in to a website with proper credentials and the user is taken to a blank page. 
 * How would you troubleshoot that? 
 * 24. prepare variations of sliding time window system design for big data systems, and you will be able 
 * to answer questions here)
25. You have a potentially very-large set of documents, which are potentially very-large, and contain text.
 For searching these documents, they've been pre-processed into a (very-large) table mapping words to the 
 set of documents that contain each word. E.g.

(word) : (documents (referenced by ID) containing that word)
Apple: 1, 4, 5, 6, 32
Banana: 5, 6, 7, 9, 32
Cantaloupe: 1, 2, 6
...
This is about designing a system with reverse index like Lucene.
1) Tokenize all documents and extract words out of them. remove stop words like the, a if etc.
2)Create a reverse index. We can create index of reverse index as well. Reverse index is structure where against each token( word) we store documents ids.
3) now when user send query we can extract documents against each indivdual words from reverse index and then do a "AND".
4) Right thing to do is to use distributed architecture and store documents on multiple machines. We can store our index in memory and do sharding of indexes and also stire index on multiple machines ( HDFS architecture)
use map and reduce

Clients will pass in a set of words (e.g. {apple, cantaloupe}), and want the set of document IDs that 
contain all the words. (e.g. {apple, cantaloupe} -> {1, 6}) Design a distributed system to implement this, 
bearing in mind that the number of documents, the number of words, and the number of document-IDs-per-word 
are potentially really, really big. 

26. How to apply the function of finding a string in the text of vim editor?  problems in linear time, 
such as KMP and Boyer-Moore, etc.
http://courses.csail.mit.edu/iap/interview/Hacking_a_Google_Interview_Practice_Questions_Person_A.pdf

28. Types of OSPF packets.
29. Avoiding loops in BGP. iBGP & eBGP.
30.Working with vlans?
31. Default gateways?
32. Routing between the network?
33. In detail ospf? 

36. How to find if nodes in graph are exactly 1/2/3 edges apart. how would you distribute graph across 
machines.

38. Implement a delayed scheduler for jobs using pthread apis (mutex/cond_var)
39. You have bunch of numbers coming in, and a given a window size, how would you save numbers so… that you 
can return number if present in window and provide average for current window.
40. They want me to design a scalable prototype of basic information retrieval system.
41. For me all the coding questions are coming from geeksforgeeks, one is about string matching, the other is 
set partition. The system design question is about basic information retrieval system, like a search engine 
prototype. If you are not familiar with this topic, the first chapter of Introduction of information retrieval will cover everything you need to know for the interview.
42. Design a system to integrate education certificate from external vendors to LinkedIn. 
43. Rest systemdesign. Amazon website design. Read/Write locking. Generate all factoring components. 

d) Design an Hangman. { They expect MVC architecture. }  

45. - How will you design an app (client) & server to implement a word guess game. For e.g. app will ask 
user to guess the word (it will show blank spaces first equal to size of the word) one character one 
time. He will have 'n' chances to guess correct word. Based on the result, he will win or loose money (prize).
46.  number of ways you can solve this problem.
  - WAP to implement function public String replace (String originalString, String pattern, String 
  replacement) Cover all boundary cases. Write clean code
  
50. You need to distribute a terabyte of data from a single server to 10,000 nodes, and then keep that data
 up to date. It takes several hours to copy the data just to one server. How would you do this so that it
  didn't take 20,000 hours to update all the servers? Also, how would you make sure that the file wasn't 
  corrupted during the copy?
51.  Implement a hash table  and Describe prototypal inheritance.  
53. my own web crawler system.
54.to find the longest arithmetic progression in an array of integers. 

58.design amazon.com

61.like load-balanced message queues, distributed hashmaps of sorted structs containing 5 URLs and their 
timestamps, and using LRU methods to GC the old data. I had to ask for a hint, but that likely sealed my 
fate. The better, but certainly not the only, solution would be to use buckets of a fixed time interval. 
Seems easy, but often times the bad ideas just won't go away when under pressure.
  How would you design an enhancement to the LinkedIn homepage that displays 24-hour trailing lists 
  (5-minute, 1-hour, 1-day) of the top 5 URLs that users post onto the site?  

62.  Given an interface called IntStream with methods 'bool hasNext()' and 'int next()', implement the 
function 'IntStream merge(IntStream[] streams)' where each input IntStream produces strictly increasing, 
possibly infinite number of, integers, and the resultant IntStream also produces strictly increasing 
integers by merging the input streams. The interviewer also provides a simple test harness that prints the
first 5000 integers from that function. 

64.design the LinkedIn job search engine.
67. Talk about a product that you wanna build at linkedin 

68. Describe a routine which returns the set of integers in {1..100} divisible without remainder by 3 but not by 9. 
	if(i%3 == 0 && i%9 != 0) 
	
	Systems Design :
- Design the Hangman game. The focus was on architecture of the system (including API's, backend storage etc.)  
Case study on elevators in a building  
How would you improve LinkedIn's personal profile page? 
70. Online system design for monitoring 
72.design recommendation engine for jobs 
_73. generic HashMap implementation,
74.Design and code a system that can accept millions of events in real time and report the number of events for the last 10 minutes (sliding window). The system has to account for performance and concurrency. -> b+ tree indexing
 Message queues
 consider a B2C website like Amazon, which will receive thousands requests from buyer per minutes. How will you design the "shop cart " component for it? where should the customs' shop cart data stored?  
 ->http://www.careercup.com/question?id=14965670
 Problem using a Trie data structure to find all possible words occurring in a data set. Output should be a set containing all words that occur in data set.
 Design and code a cache.  
 https://goo.gl/u5NtxM
 75.How do you search thrgough huge flatfile? 
  78. Question about approaches to locking a hash table and how to optimize for a very large table.
 79. If we wanted to implement a method of tracking every click  that the user made on the site, how would we want to do this?
80. How do you get the ip of a machine without a monitor?  
What would you do to increase users signing up for LinkedIn?  
81.Java: how do you make n threads run at the same time? 
*/


public class urlShortner {
	
}
