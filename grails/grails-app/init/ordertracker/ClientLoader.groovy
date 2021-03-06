package ordertracker
import ordertracker.constants.ClientStates

class ClientLoader {

    public static int clientsLoaded = 58

    def load() {
        new Client(name: 'Juan',    address: 'Av. Pres. Figueroa Alcorta 3535', city: 'Ciudad de Buenos Aires',qrcode: 'A', email: 'a@a.com').save()
        new Client(name: 'Felipe',  address: 'Juana Manso 530', city: 'Ciudad de Buenos Aires', qrcode: 'B', email: 'b@b.com').save()
        new Client(name: 'Matias',  address: 'Av. del Libertador 1659',city: 'Ciudad de Buenos Aires', qrcode: 'C', email: 'c@c.com').save()
        new Client(name: 'Maria',  address: 'Av. Coronel Roca 5252',city: 'Ciudad de Buenos Aires', qrcode: 'D', email: 'd@d.com').save()
        new Client(name: 'Fernando',  address: 'Av. Sarmiento 1118',city: 'Ciudad de Buenos Aires', qrcode: 'E', email: 'e@e.com').save()
        new Client(name: 'Carolina',  address: 'Av. San Juan 1340',city: 'Ciudad de Buenos Aires', qrcode: 'F', email: 'f@f.com').save()
        new Client(name: 'Elena',  address: 'Av. Bartolome Mitre 726',city: 'Ciudad de Buenos Aires', qrcode: 'G', email: 'g@g.com').save()
        new Client(name: 'Konstantin Novoselov',  address: 'Av. Corrientes 250',city: 'Ciudad de Buenos Aires', qrcode: 'H', email: 'KonstantinNovoselov@gmail.com').save()
        new Client(name: 'Andre Geim',  address: 'Av. Corrientes 300',city: 'Ciudad de Buenos Aires', qrcode: 'H', email: 'AndreGeim@gmail.com').save()
        new Client(name: 'George E. Smith',  address: 'Av. Corrientes 350',city: 'Ciudad de Buenos Aires', qrcode: 'H', email: 'GeorgeE.Smith@gmail.com').save()
        new Client(name: 'Willard S. Boyle',  address: 'Av. Corrientes 400',city: 'Ciudad de Buenos Aires', qrcode: 'H', email: 'WillardS.Boyle@gmail.com').save()
        new Client(name: 'Charles K. Kao',  address: 'Av. Corrientes 450',city: 'Ciudad de Buenos Aires', qrcode: 'H', email: 'CharlesK.Kao@gmail.com').save()
        new Client(name: 'Toshihide Maskawa',  address: 'Av. Corrientes 500',city: 'Ciudad de Buenos Aires', qrcode: 'H', email: 'ToshihideMaskawa@gmail.com').save()
        new Client(name: 'Makoto Kobayashi',  address: 'Av. Corrientes 550',city: 'Ciudad de Buenos Aires', qrcode: 'H', email: 'MakotoKobayashi@gmail.com').save()
        new Client(name: 'Yoichiro Nambu',  address: 'Av. Corrientes 600',city: 'Ciudad de Buenos Aires', qrcode: 'H', email: 'YoichiroNambu@gmail.com').save()
        new Client(name: 'Peter Grunberg',  address: 'Av. Corrientes 650',city: 'Ciudad de Buenos Aires', qrcode: 'H', email: 'PeterGrunberg@gmail.com').save()
        new Client(name: 'Albert Fert',  address: 'Av. Corrientes 700',city: 'Ciudad de Buenos Aires', qrcode: 'H', email: 'AlbertFert@gmail.com').save()
        new Client(name: 'George F. Smoot',  address: 'Av. Corrientes 750',city: 'Ciudad de Buenos Aires', qrcode: 'H', email: 'GeorgeF.Smoot@gmail.com').save()
        new Client(name: 'John C. Mather',  address: 'Av. Corrientes 800',city: 'Ciudad de Buenos Aires', qrcode: 'H', email: 'JohnC.Mather@gmail.com').save()
        new Client(name: 'Theodor W. Hansch',  address: 'Av. Corrientes 850',city: 'Ciudad de Buenos Aires', qrcode: 'H', email: 'TheodorW.Hansch@gmail.com').save()
        new Client(name: 'John L. Hall',  address: 'Av. Corrientes 900',city: 'Ciudad de Buenos Aires', qrcode: 'H', email: 'JohnL.Hall@gmail.com').save()
        new Client(name: 'Roy J. Glauber',  address: 'Av. Corrientes 950',city: 'Ciudad de Buenos Aires', qrcode: 'H', email: 'RoyJ.Glauber@gmail.com').save()
        new Client(name: 'Frank Wilczek',  address: 'Av. Corrientes 1000',city: 'Ciudad de Buenos Aires', qrcode: 'H', email: 'FrankWilczek@gmail.com').save()
        new Client(name: 'H. David Politzer',  address: 'Av. Corrientes 1050',city: 'Ciudad de Buenos Aires', qrcode: 'H', email: 'H.DavidPolitzer@gmail.com').save()
        new Client(name: 'David J. Gross',  address: 'Av. Corrientes 1100',city: 'Ciudad de Buenos Aires', qrcode: 'H', email: 'DavidJ.Gross@gmail.com').save()
        new Client(name: 'Anthony J. Leggett',  address: 'Av. Corrientes 1150',city: 'Ciudad de Buenos Aires', qrcode: 'H', email: 'AnthonyJ.Leggett@gmail.com').save()
        new Client(name: 'Vitaly L. Ginzburg',  address: 'Av. Corrientes 1200',city: 'Ciudad de Buenos Aires', qrcode: 'H', email: 'VitalyL.Ginzburg@gmail.com').save()
        new Client(name: 'Alexei A. Abrikosov',  address: 'Av. Corrientes 1250',city: 'Ciudad de Buenos Aires', qrcode: 'H', email: 'AlexeiA.Abrikosov@gmail.com').save()
        new Client(name: 'Riccardo Giacconi',  address: 'Av. Corrientes 1300',city: 'Ciudad de Buenos Aires', qrcode: 'H', email: 'RiccardoGiacconi@gmail.com').save()
        new Client(name: 'Masatoshi Koshiba',  address: 'Av. Corrientes 1350',city: 'Ciudad de Buenos Aires', qrcode: 'H', email: 'MasatoshiKoshiba@gmail.com').save()
        new Client(name: 'Raymond Davis, Jr.',  address: 'Av. Corrientes 1400',city: 'Ciudad de Buenos Aires', qrcode: 'H', email: 'RaymondDavis,Jr.@gmail.com').save()
        new Client(name: 'Carl E. Wieman',  address: 'Av. Corrientes 1450',city: 'Ciudad de Buenos Aires', qrcode: 'H', email: 'CarlE.Wieman@gmail.com').save()
        new Client(name: 'Wolfgang Ketterle',  address: 'Av. Corrientes 1500',city: 'Ciudad de Buenos Aires', qrcode: 'H', email: 'WolfgangKetterle@gmail.com').save()
        new Client(name: 'Eric A. Cornell',  address: 'Av. Corrientes 1550',city: 'Ciudad de Buenos Aires', qrcode: 'H', email: 'EricA.Cornell@gmail.com').save()
        new Client(name: 'Jack Kilby',  address: 'Av. Corrientes 1600',city: 'Ciudad de Buenos Aires', qrcode: 'H', email: 'JackKilby@gmail.com').save()
        new Client(name: 'Herbert Kroemer',  address: 'Av. Corrientes 1650',city: 'Ciudad de Buenos Aires', qrcode: 'H', email: 'HerbertKroemer@gmail.com').save()
        new Client(name: 'Zhores I. Alferov',  address: 'Av. Corrientes 1700',city: 'Ciudad de Buenos Aires', qrcode: 'H', email: 'ZhoresI.Alferov@gmail.com').save()
        new Client(name: 'Martinus J.G. Veltman',  address: 'Av. Corrientes 1750',city: 'Ciudad de Buenos Aires', qrcode: 'H', email: 'MartinusJ.G.Veltman@gmail.com').save()
        new Client(name: 'Gerardus t Hooft',  address: 'Av. Corrientes 1800',city: 'Ciudad de Buenos Aires', qrcode: 'H', email: 'GerardustHooft@gmail.com').save()
        new Client(name: 'Daniel C. Tsui',  address: 'Av. Corrientes 1850',city: 'Ciudad de Buenos Aires', qrcode: 'H', email: 'DanielC.Tsui@gmail.com').save()
        new Client(name: 'Horst L. Stormer',  address: 'Av. Corrientes 1900',city: 'Ciudad de Buenos Aires', qrcode: 'H', email: 'HorstL.Stormer@gmail.com').save()
        new Client(name: 'Robert B. Laughlin',  address: 'Av. Corrientes 1950',city: 'Ciudad de Buenos Aires', qrcode: 'H', email: 'RobertB.Laughlin@gmail.com').save()
        new Client(name: 'William D. Phillips',  address: 'Av. Corrientes 2000',city: 'Ciudad de Buenos Aires', qrcode: 'H', email: 'WilliamD.Phillips@gmail.com').save()
        new Client(name: 'Claude Cohen-Tannoudji',  address: 'Av. Corrientes 2050',city: 'Ciudad de Buenos Aires', qrcode: 'H', email: 'ClaudeCohen-Tannoudji@gmail.com').save()
        new Client(name: 'Steven Chu',  address: 'Av. Corrientes 2100',city: 'Ciudad de Buenos Aires', qrcode: 'H', email: 'StevenChu@gmail.com').save()
        new Client(name: 'Robert Coleman Richardson',  address: 'Av. Corrientes 2150',city: 'Ciudad de Buenos Aires', qrcode: 'H', email: 'RobertColemanRichardson@gmail.com').save()
        new Client(name: 'Douglas D. Osheroff',  address: 'Av. Corrientes 2200',city: 'Ciudad de Buenos Aires', qrcode: 'H', email: 'DouglasD.Osheroff@gmail.com').save()
        new Client(name: 'David M. Lee',  address: 'Av. Corrientes 2250',city: 'Ciudad de Buenos Aires', qrcode: 'H', email: 'DavidM.Lee@gmail.com').save()
        new Client(name: 'Frederick Reines',  address: 'Av. Corrientes 2300',city: 'Ciudad de Buenos Aires', qrcode: 'H', email: 'FrederickReines@gmail.com').save()
        new Client(name: 'Martin L. Perl',  address: 'Av. Corrientes 2350',city: 'Ciudad de Buenos Aires', qrcode: 'H', email: 'MartinL.Perl@gmail.com').save()
        new Client(name: 'Clifford G. Shull',  address: 'Av. Corrientes 2400',city: 'Ciudad de Buenos Aires', qrcode: 'H', email: 'CliffordG.Shull@gmail.com').save()
        new Client(name: 'Bertram N. Brockhouse',  address: 'Av. Corrientes 2450',city: 'Ciudad de Buenos Aires', qrcode: 'H', email: 'BertramN.Brockhouse@gmail.com').save()
        new Client(name: 'Joseph H. Taylor, Jr.',  address: 'Av. Corrientes 2500',city: 'Ciudad de Buenos Aires', qrcode: 'H', email: 'JosephH.Taylor,Jr.@gmail.com').save()
        new Client(name: 'Russell A. Hulse',  address: 'Av. Corrientes 2550',city: 'Ciudad de Buenos Aires', qrcode: 'H', email: 'RussellA.Hulse@gmail.com').save()
        new Client(name: 'Georges Charpak',  address: 'Av. Corrientes 2600',city: 'Ciudad de Buenos Aires', qrcode: 'H', email: 'GeorgesCharpak@gmail.com').save()
        new Client(name: 'Pierre-Gilles de Gennes',  address: 'Av. Corrientes 2650',city: 'Ciudad de Buenos Aires', qrcode: 'H', email: 'Pierre-GillesdeGennes@gmail.com').save()
        new Client(name: 'Subramanyan Chandrasekhar',  address: 'Av. Corrientes 2700',city: 'Ciudad de Buenos Aires', qrcode: 'H', email: 'SubramanyanChandrasekhar@gmail.com').save()
        new Client(name: 'Robert Woodrow Wilson',  address: 'Av. Corrientes 2750',city: 'Ciudad de Buenos Aires', qrcode: 'H', email: 'RobertWoodrowWilson@gmail.com').save()
        
        
        

    }
}