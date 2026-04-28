Try to finish all the implementations for trees this week

Repository to practice DSA

Test cases in main methods are generated with AI


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






