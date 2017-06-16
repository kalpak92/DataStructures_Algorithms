__author__ = 'Kalpak Seal'

'''
Question:
Given an array with +ive integers, return a pair with highest product.
'''

def maximum_pairwise_product(arr):
	max1 = 0
	max2= 0
	
	for i in range(len(arr)):
		if arr[i] > max1 or arr[i] > max2:
			max1 = max(max1, max2)
			max2 = arr[i]
	
	return (max1*max2)

def main():
	arr = [1, 4, 3, 28, 7, 0]
	print("The maximum pairwise product is: ", maximum_pairwise_product(arr))

if __name__ == '__main__':
	main()
