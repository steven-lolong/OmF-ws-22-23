#include <iostream>
using namespace std;
class Car
{
private:
	int numWheel = 4;

protected:
	int numHonk = 7;
};
class SUV : public Car
{
public:
	void honk()
	{
		cout << "Tet..." << Car::numHonk << endl;
	}
};

int main()
{
	SUV suv;
	suv.honk();
	cout << "Hello world!" << endl;
	return 0;
}