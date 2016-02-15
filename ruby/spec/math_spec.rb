require 'simplecov'
SimpleCov.start

require 'math'

RSpec.describe Vector do
	context "with (2,3,4)" do
		it "checks if initialized correctly" do
			v = Vector.new(2,3,4)
			
			expect(v.x).to eq 2
			expect(v.y).to eq 3
			expect(v.z).to eq 4
		end
	end
end

RSpec.describe Vector do
	context "with (4,0,0)" do
		it "checks if length computes correctly" do
			v = Vector.new(4,0,0)
			l = v.length()
			
			expect(l).to eq 4
		end
	end
end

RSpec.describe Vector do
	context "with (2,3,4)" do
		it "checks if normalize computes correctly" do
			v = Vector.new(2,3,4)
			l1 = v.length()
			v = v.normalize()
			l2 = v.length()
			
			expect(l1).not_to eq 1
			expect(l2).to eq 1
		end
	end
end

RSpec.describe Vector do
	context "with (2,3,4)" do
		it "checks if negate computes correctly" do
			v = Vector.new(2,3,4).negate()
			
			expect(v.x).to eq -2
			expect(v.y).to eq -3
			expect(v.z).to eq -4
		end
	end
end

RSpec.describe Vector do
	context "with v1=(0,0,0) v2=(0,0,0) v3=(0,1,0)" do
		it "checks if equals works" do
			v1 = Vector.new(0,0,0)
			v2 = Vector.new(0,0,0)
			v3 = Vector.new(0,1,0)
			
			expect(v1.equals(v1)).to eq true
			expect(v1.equals(v2)).to eq true
			expect(v1.equals(v3)).to eq false
		end
	end
end

RSpec.describe Vector do
	context "with v1=(2,3,4) v2=(8,11,13)" do
		it "checks if vector add operation works" do
			v1 = Vector.new(2,3,4)
			v2 = Vector.new(8,11,13)
			v = v1.add(v2)
			
			expect(v.x).to eq 10
			expect(v.y).to eq 14
			expect(v.z).to eq 17
		end
	end
end

RSpec.describe Vector do
	context "with v1=(2,3,4) v2=(8,11,13)" do
		it "checks if vector subtract operation works" do
			v1 = Vector.new(2,3,4)
			v2 = Vector.new(8,11,13)
			v = v1.subtract(v2)
			
			expect(v.x).to eq -6
			expect(v.y).to eq -8
			expect(v.z).to eq -9
		end
	end
end

RSpec.describe Vector do
	context "with v1=(2,3,4) v2=(8,11,13)" do
		it "checks if vector multiply operation works" do
			v1 = Vector.new(2,3,4)
			v2 = Vector.new(8,11,13)
			v = v1.multiply(v2)
			
			expect(v.x).to eq 16
			expect(v.y).to eq 33
			expect(v.z).to eq 52
		end
	end
end

RSpec.describe Vector do
	context "with v1=(2,3,4) v2=(8,24,20)" do
		it "checks if vector divide operation works" do
			v1 = Vector.new(2,3,4)
			v2 = Vector.new(8,24,20)
			v = v1.divide(v2)

			expect(v.x).to eq 0.25
			expect(v.y).to eq 0.125
			expect(v.z).to eq 0.2
		end
	end
end

RSpec.describe Vector do
	context "with v1=(2,3,4) v2=(8,11,13)" do
		it "checks if vector min computes correctly" do
			v1 = Vector.new(2,3,4)
			v2 = Vector.new(8,11,13)
			v = v1.min(v2)
			
			expect(v.x).to eq v1.x
			expect(v.y).to eq v1.y
			expect(v.z).to eq v1.z
		end
	end
end

RSpec.describe Vector do
	context "with v1=(2,3,4) v2=(8,11,13)" do
		it "checks if vector max computes correctly" do
			v1 = Vector.new(2,3,4)
			v2 = Vector.new(8,11,13)
			v = v1.max(v2)
			
			expect(v.x).to eq v2.x
			expect(v.y).to eq v2.y
			expect(v.z).to eq v2.z
		end
	end
end

RSpec.describe Vector do
	context "with v1=(2,3,4) v2=(8,11,13)" do
		it "checks if vector cross computes correctly" do
			v1 = Vector.new(2,3,4)
			v2 = Vector.new(8,11,13)
			v = v1.cross(v2)
			
			expect(v.x).to eq -5
			expect(v.y).to eq 6
			expect(v.z).to eq -2
		end
	end
end

RSpec.describe Vector do
	context "with v1=(2,3,4) v2=(8,11,13)" do
		it "checks if vector reflect computes correctly" do
			v1 = Vector.new(2,3,4)
			v2 = Vector.new(8,11,13)
			v = v1.reflect(v2)

			expect(v.x).to eq -1614
			expect(v.y).to eq -2219
			expect(v.z).to eq -2622
		end
	end
end

RSpec.describe Vector do
	context "with v1=(17,18,19) m1=(1,2,3,4, 5,6,7,8, 9,10,11,12, 13,14,15,16)" do
		it "checks if vector transform computes correctly" do
			v1 = Vector.new(17,18,19)
			m1 = Matrix.new(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16)
			v = v1.transform(m1)
			
			expect(v.x).to eq 291
			expect(v.y).to eq 346
			expect(v.z).to eq 401
		end
	end
end

RSpec.describe Vector do
	context "with v1=(2,3,4) v2=(8,11,13)" do
		it "checks if vector dot product computes correctly" do
			v1 = Vector.new(2,3,4)
			v2 = Vector.new(8,11,13)
			d = v1.dot(v2)
			
			expect(d).to eq 101
		end
	end
end

RSpec.describe Vector do
	context "with v1=(2,3,4) v2=(8,11,13)" do
		it "checks if vector distance computes correctly" do
			v1 = Vector.new(2,3,4)
			v2 = Vector.new(8,11,13)
			d = v1.distance(v2)

			expect(d).to eq 13.45362404707371031716308546217
		end
	end
end

RSpec.describe Matrix do
	context "with (1,2,3,4, 5,6,7,8, 9,10,11,12, 13,14,15,16)" do
		it "checks if initialized correctly" do
			m = Matrix.new(1,2,3,4, 5,6,7,8, 9,10,11,12, 13,14,15,16)
			
			expect(m.m11).to eq 1
			expect(m.m12).to eq 2
			expect(m.m13).to eq 3
			expect(m.m14).to eq 4

			expect(m.m21).to eq 5
			expect(m.m22).to eq 6
			expect(m.m23).to eq 7
			expect(m.m24).to eq 8

			expect(m.m31).to eq 9
			expect(m.m32).to eq 10
			expect(m.m33).to eq 11
			expect(m.m34).to eq 12

			expect(m.m41).to eq 13
			expect(m.m42).to eq 14
			expect(m.m43).to eq 15
			expect(m.m44).to eq 16
		end
	end
end
