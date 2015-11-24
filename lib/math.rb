class Vector
	@x
	@y
	@z
	def initialize(x, y, z)
		@x = Float(x)
		@y = Float(y)
		@z = Float(z)
	end
	def x()
		@x
	end
	def y()
		@y
	end
	def z()
		@z
	end
	def length()
		Math.sqrt(self.x * self.x + self.y * self.y + self.z * self.z);
	end
	def normalize()
		factor = 1 / self.length()
		self.multiply(Vector.new(factor, factor, factor))
	end
	def negate()
		x = -self.x
		y = -self.y
		z = -self.z
		Vector.new(x,y,z)
	end
	def equals(vector)
		self.x == vector.x && self.y == vector.y && self.z == vector.z
	end
	def add(vector)
		x = self.x + vector.x
		y = self.y + vector.y
		z = self.z + vector.z
		Vector.new(x,y,z)
	end
	def subtract(vector)
		x = self.x - vector.x
		y = self.y - vector.y
		z = self.z - vector.z
		Vector.new(x,y,z)
	end
	def multiply(vector)
		x = self.x * vector.x
		y = self.y * vector.y
		z = self.z * vector.z
		Vector.new(x,y,z)
	end
	def divide(vector)
		x = self.x / vector.x
		y = self.y / vector.y
		z = self.z / vector.z
		Vector.new(x,y,z)
	end
	def min(vector)
		x = (self.x < vector.x ? self.x : vector.x);
		y = (self.y < vector.y ? self.y : vector.y);
		z = (self.z < vector.z ? self.z : vector.z);
		Vector.new(x,y,z)
	end
	def max(vector)
		x = (self.x > vector.x ? self.x : vector.x);
		y = (self.y > vector.y ? self.y : vector.y);
		z = (self.z > vector.z ? self.z : vector.z);
		Vector.new(x,y,z)
	end
	def cross(vector)
		x = self.y * vector.z - self.z * vector.y;
		y = self.z * vector.x - self.x * vector.z;
		z = self.x * vector.y - self.y * vector.x;
		Vector.new(x,y,z)
	end
	def reflect(normal)
		d2 = 2 * self.dot(normal)
		x = self.x - d2 * normal.x;
		y = self.y - d2 * normal.y;
		z = self.z - d2 * normal.z;
		Vector.new(x,y,z)
	end
	def transform(matrix)
		x = self.x * matrix.m11 + self.y * matrix.m21 + self.z * matrix.m31 + matrix.m41
		y = self.x * matrix.m12 + self.y * matrix.m22 + self.z * matrix.m32 + matrix.m42
		z = self.x * matrix.m13 + self.y * matrix.m23 + self.z * matrix.m33 + matrix.m43
		Vector.new(x,y,z)
	end
	def dot(vector)
		self.x * vector.x + self.y * vector.y + self.z * vector.z
	end
	def distance(vector)
		x = self.x - vector.x;
		y = self.y - vector.y;
		z = self.z - vector.z;
		single = x * x + y * y + z * z;
		Math.sqrt(single)
	end
end

class Matrix
	@m11
	@m12
	@m13
	@m14
	@m21
	@m22
	@m23
	@m24
	@m31
	@m32
	@m33
	@m34
	@m41
	@m42
	@m43
	@m44
	def initialize(m11, m12, m13, m14, m21, m22, m23, m24, m31, m32, m33, m34, m41, m42, m43, m44)
		@m11 = Float(m11)
		@m12 = Float(m12)
		@m13 = Float(m13)
		@m14 = Float(m14)

		@m21 = Float(m21)
		@m22 = Float(m22)
		@m23 = Float(m23)
		@m24 = Float(m24)

		@m31 = Float(m31)
		@m32 = Float(m32)
		@m33 = Float(m33)
		@m34 = Float(m34)

		@m41 = Float(m41)
		@m42 = Float(m42)
		@m43 = Float(m43)
		@m44 = Float(m44)
	end
	def m11()
		@m11
	end
	def m12()
		@m12
	end
	def m13()
		@m13
	end
	def m14()
		@m14
	end
	def m21()
		@m21
	end
	def m22()
		@m22
	end
	def m23()
		@m23
	end
	def m24()
		@m24
	end
	def m31()
		@m31
	end
	def m32()
		@m32
	end
	def m33()
		@m33
	end
	def m34()
		@m34
	end
	def m41()
		@m41
	end
	def m42()
		@m42
	end
	def m43()
		@m43
	end
	def m44()
		@m44
	end
end
