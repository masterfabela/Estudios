import doctest
def calculoimc(altura,masa):
	"""
	>>> calculoimc(1,1)
	1.0
	>>> calculoimc(1,1)
	0.0
	>>> calculoimc(2,2)
	0.5
	"""
	altura=altura**2
	imc=masa/altura
	imc=round(imc,2)
	return imc

if __name__ == '__main__':
	doctest.testmod()
	h=float(input('Dame la altura: '))
	m=float(input('Dame la masa: '))
	print(' El resultado es %.2f '  % calculoimc(h,m))


