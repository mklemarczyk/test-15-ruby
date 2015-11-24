class Vector
	@x
	@y
	@z
	def initialize(x, y, z)
		@x = x
		@y = y
		@z = z
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
		self.multiply(factor, factor, factor)
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
		x = (value1.X < value2.X ? value1.X : value2.X);
		y = (value1.Y < value2.Y ? value1.Y : value2.Y);
		z = (value1.Z < value2.Z ? value1.Z : value2.Z);
		Vector.new(x,y,z)
	end
	def max(vector)
		x = (value1.X > value2.X ? value1.X : value2.X);
		y = (value1.Y > value2.Y ? value1.Y : value2.Y);
		z = (value1.Z > value2.Z ? value1.Z : value2.Z);
		Vector.new(x,y,z)
	end
	def cross(vector)
		x = vector1.Y * vector2.Z - vector1.Z * vector2.Y;
		y = vector1.Z * vector2.X - vector1.X * vector2.Z;
		z = vector1.X * vector2.Y - vector1.Y * vector2.X;
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
		x = self.X - value.X;
		y = self.Y - value.Y;
		z = self.Z - value.Z;
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
		@m11 = m11
		@m12 = m12
		@m13 = m13
		@m14 = m14

		@m21 = m21
		@m22 = m22
		@m23 = m23
		@m24 = m24

		@m31 = m31
		@m32 = m32
		@m33 = m33
		@m34 = m34

		@m41 = m41
		@m42 = m42
		@m43 = m43
		@m44 = m44
	end
end
