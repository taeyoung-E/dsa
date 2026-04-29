Also shows to-do list of DSA

Repository to practice DSA

Test cases in main methods are generated with AI



Heap Implementation Tomorrow

버블은 옆에거랑 비교하면서 계속 traverse하면서 swap

Selection은 최솟값인 인덱스를 traverse하면서 기억하고 traversal이 끝나면 swap하고 search range - 1

Insertion은 Partially sorted일때 더 빨리 종료될수 있기때문에 실무에서 더 많이 쓴다 Sort된 partition에서 그 이후의 인덱스 하나랑만
비교하면서 swap하고 sorted되면 다시 그전단계를 continue.

Merge Sort, Recursion으로 나눠서 sort하고 합친다 O(n log n), Space Complexity는 O(n)

Quick Sort, Must learn
also use divide and conquer using recursion

Pivot값을 고른다음 (보통 그냥 size/2 중간 index) 그 pivot값을 비교해서 left portion, right portion을 만든뒤,
재귀적으로 또 그 portion에 대한 pivot 값을 고르고 반복, portion 크기가 1이면 재귀 종료
Split된 배열들을 그냥 merge할뿐

Merge sort(Compare as you merge)

Quick(Just merge it because it's sorted)

Heap Sort
Similar to taking out the root in the priority queue

HashMap Chaining Method/Open Addressing
Chaining Method refers to saving the collided value in the index through Linked List(O(n) though in modern java
It's saved as Red Black tree after 8 items are in a same bucket)

On collision, both HashMap and HashSet saves multiple elements in the same bucket, but when attempting to override
with same key and different values, only HashMap overwrites to the new entry where HashSet simply ignores it

Open Addressing Refers to finding another empty location on collision and inserting it there(Linear Probing)

Null is a condition to end the search which is why, on deletion using open addressing, we need to mark the deleted
index so the search loop doeesn't get terminated prematurly after seeing a null value in the arary

Graph
Graphs are made of vertices(nodes) and edges. 
The edges may have direction or weights








