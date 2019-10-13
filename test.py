def func ():

	mapping = [2,1,4,8,6,3,0,9,7,5,8]
	nums = ["12","02","50","4","023","65","83","224","50"] 	#668 004

	result = []

	# num = [int (i) for i in nums]

	for num in nums:
		a = ""
		for j in range(len(num)):
			#print (num[j])
			a += str(mapping.index(int(num[j])))
		#print(a)
		result.append(a)

	print(result)

	r = [int (i) for i in result]
	#print(r)
	
	
	dictionary = dict(zip(result, nums))
	print (dictionary)
	
	#print (sorted(dictionary.keys()))
	keys = [int (i) for i in dictionary.keys()]
	#print(keys)
	final = []

	for key in dictionary.keys():
		k = int(key)
		final.append((k,dictionary[key]))

	print(final)

	f = sorted(final, key = lambda x :x[0])
	print (f)
	
	for i in f:
		print(i[-1])


if __name__ == "__main__":
	func()
	



