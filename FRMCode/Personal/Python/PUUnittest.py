import unittest
def calculoimc(altura,masa):
	altura=altura**2
	imc=masa/altura
	imc=round(imc,2)
	return imc
class tester(unittest.TestCase):
	def test1(self):
		self.assertEqual(1,calculoimc(1,1))
	def test2(self):
		self.assertEqual(0,calculoimc(1,1))
	def test3(self):
		self.assertEqual(0.5,calculoimc(2,2))

if __name__ == '__main__':
	unittest.main()
	h=float(input('Dame la altura: '))
	m=float(input('Dame la masa: '))
	print(' El resultado es %.2f '  % calculoimc(h,m))

