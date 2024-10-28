class BinarySearch:
    def search(self, list, target):
        left = 0
        right = len(list) - 1
        while(left <= right):
            mid = (left + right) // 2
            #mid = left + ((right - left) // 2)
            if(list[mid] < target):
                left = mid + 1
            else:
                if(list[mid] > target):
                    right = mid - 1
                else:
                    return mid
        return -1

bsclass = BinarySearch()

searchlist = [-1,0,3,5,9,12]
ret = bsclass.search(searchlist, 9)
print("return =  " + str(ret))