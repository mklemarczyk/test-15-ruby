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
