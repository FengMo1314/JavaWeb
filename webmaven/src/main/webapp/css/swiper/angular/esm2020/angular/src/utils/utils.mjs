export function isObject(o) {
    return (typeof o === 'object' &&
        o !== null &&
        o.constructor &&
        Object.prototype.toString.call(o).slice(8, -1) === 'Object');
}

export function isEnabled(val) {
    return typeof val !== 'undefined' && typeof val !== 'boolean' && val.enabled === true;
}

export function isShowEl(val, obj, el) {
    return ((coerceBooleanProperty(val) === true && obj && !obj.el) ||
        !(typeof obj !== 'boolean' &&
            obj.el !== el?.nativeElement &&
            (typeof obj.el === 'string' || typeof obj.el === 'object')));
}

export function extend(target, src) {
    const noExtend = ['__proto__', 'constructor', 'prototype'];
    Object.keys(src)
        .filter((key) => noExtend.indexOf(key) < 0)
        .forEach((key) => {
            if (typeof target[key] === 'undefined') {
                target[key] = src[key];
                return;
            }
            if (target[key] && !src[key]) {
                return;
            }
            if (isObject(src[key]) && isObject(target[key]) && Object.keys(src[key]).length > 0) {
                if (src[key].__swiper__)
                    target[key] = src[key];
                else
                    extend(target[key], src[key]);
            } else {
                target[key] = src[key];
            }
        });
}

export function coerceBooleanProperty(value) {
    return value != null && `${value}` !== 'false';
}

export const ignoreNgOnChanges = ['pagination', 'navigation', 'scrollbar', 'virtual'];

export function setProperty(val, obj = {}) {
    if (isObject(val)) {
        return val;
    }
    if (coerceBooleanProperty(val) === true) {
        return obj;
    }
    return false;
}

//# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJmaWxlIjoidXRpbHMuanMiLCJzb3VyY2VSb290IjoiIiwic291cmNlcyI6WyIuLi8uLi8uLi8uLi8uLi8uLi9zcmMvYW5ndWxhci9zcmMvdXRpbHMvdXRpbHMudHMiXSwibmFtZXMiOltdLCJtYXBwaW5ncyI6IkFBQUEsTUFBTSxVQUFVLFFBQVEsQ0FBQyxDQUFNO0lBQzdCLE9BQU8sQ0FDTCxPQUFPLENBQUMsS0FBSyxRQUFRO1FBQ3JCLENBQUMsS0FBSyxJQUFJO1FBQ1YsQ0FBQyxDQUFDLFdBQVc7UUFDYixNQUFNLENBQUMsU0FBUyxDQUFDLFFBQVEsQ0FBQyxJQUFJLENBQUMsQ0FBQyxDQUFDLENBQUMsS0FBSyxDQUFDLENBQUMsRUFBRSxDQUFDLENBQUMsQ0FBQyxLQUFLLFFBQVEsQ0FDNUQsQ0FBQztBQUNKLENBQUM7QUFFRCxNQUFNLFVBQVUsU0FBUyxDQUFDLEdBQW9DO0lBQzVELE9BQU8sT0FBTyxHQUFHLEtBQUssV0FBVyxJQUFJLE9BQU8sR0FBRyxLQUFLLFNBQVMsSUFBSSxHQUFHLENBQUMsT0FBTyxLQUFLLElBQUksQ0FBQztBQUN4RixDQUFDO0FBRUQsTUFBTSxVQUFVLFFBQVEsQ0FBQyxHQUFRLEVBQUUsR0FBUSxFQUFFLEVBQU87SUFDbEQsT0FBTyxDQUNMLENBQUMscUJBQXFCLENBQUMsR0FBRyxDQUFDLEtBQUssSUFBSSxJQUFJLEdBQUcsSUFBSSxDQUFDLEdBQUcsQ0FBQyxFQUFFLENBQUM7UUFDdkQsQ0FBQyxDQUNDLE9BQU8sR0FBRyxLQUFLLFNBQVM7WUFDeEIsR0FBRyxDQUFDLEVBQUUsS0FBSyxFQUFFLEVBQUUsYUFBYTtZQUM1QixDQUFDLE9BQU8sR0FBRyxDQUFDLEVBQUUsS0FBSyxRQUFRLElBQUksT0FBTyxHQUFHLENBQUMsRUFBRSxLQUFLLFFBQVEsQ0FBQyxDQUMzRCxDQUNGLENBQUM7QUFDSixDQUFDO0FBRUQsTUFBTSxVQUFVLE1BQU0sQ0FBQyxNQUFXLEVBQUUsR0FBUTtJQUMxQyxNQUFNLFFBQVEsR0FBRyxDQUFDLFdBQVcsRUFBRSxhQUFhLEVBQUUsV0FBVyxDQUFDLENBQUM7SUFDM0QsTUFBTSxDQUFDLElBQUksQ0FBQyxHQUFHLENBQUM7U0FDYixNQUFNLENBQUMsQ0FBQyxHQUFHLEVBQUUsRUFBRSxDQUFDLFFBQVEsQ0FBQyxPQUFPLENBQUMsR0FBRyxDQUFDLEdBQUcsQ0FBQyxDQUFDO1NBQzFDLE9BQU8sQ0FBQyxDQUFDLEdBQUcsRUFBRSxFQUFFO1FBQ2YsSUFBSSxPQUFPLE1BQU0sQ0FBQyxHQUFHLENBQUMsS0FBSyxXQUFXLEVBQUU7WUFDdEMsTUFBTSxDQUFDLEdBQUcsQ0FBQyxHQUFHLEdBQUcsQ0FBQyxHQUFHLENBQUMsQ0FBQztZQUN2QixPQUFPO1NBQ1I7UUFDRCxJQUFJLE1BQU0sQ0FBQyxHQUFHLENBQUMsSUFBSSxDQUFDLEdBQUcsQ0FBQyxHQUFHLENBQUMsRUFBRTtZQUM1QixPQUFPO1NBQ1I7UUFDRCxJQUFJLFFBQVEsQ0FBQyxHQUFHLENBQUMsR0FBRyxDQUFDLENBQUMsSUFBSSxRQUFRLENBQUMsTUFBTSxDQUFDLEdBQUcsQ0FBQyxDQUFDLElBQUksTUFBTSxDQUFDLElBQUksQ0FBQyxHQUFHLENBQUMsR0FBRyxDQUFDLENBQUMsQ0FBQyxNQUFNLEdBQUcsQ0FBQyxFQUFFO1lBQ25GLElBQUksR0FBRyxDQUFDLEdBQUcsQ0FBQyxDQUFDLFVBQVU7Z0JBQUUsTUFBTSxDQUFDLEdBQUcsQ0FBQyxHQUFHLEdBQUcsQ0FBQyxHQUFHLENBQUMsQ0FBQzs7Z0JBQzNDLE1BQU0sQ0FBQyxNQUFNLENBQUMsR0FBRyxDQUFDLEVBQUUsR0FBRyxDQUFDLEdBQUcsQ0FBQyxDQUFDLENBQUM7U0FDcEM7YUFBTTtZQUNMLE1BQU0sQ0FBQyxHQUFHLENBQUMsR0FBRyxHQUFHLENBQUMsR0FBRyxDQUFDLENBQUM7U0FDeEI7SUFDSCxDQUFDLENBQUMsQ0FBQztBQUNQLENBQUM7QUFFRCxNQUFNLFVBQVUscUJBQXFCLENBQUMsS0FBVTtJQUM5QyxPQUFPLEtBQUssSUFBSSxJQUFJLElBQUksR0FBRyxLQUFLLEVBQUUsS0FBSyxPQUFPLENBQUM7QUFDakQsQ0FBQztBQUVELE1BQU0sQ0FBQyxNQUFNLGlCQUFpQixHQUFHLENBQUMsWUFBWSxFQUFFLFlBQVksRUFBRSxXQUFXLEVBQUUsU0FBUyxDQUFDLENBQUM7QUFFdEYsTUFBTSxVQUFVLFdBQVcsQ0FBQyxHQUFRLEVBQUUsR0FBRyxHQUFHLEVBQUU7SUFDNUMsSUFBSSxRQUFRLENBQUMsR0FBRyxDQUFDLEVBQUU7UUFDakIsT0FBTyxHQUFHLENBQUM7S0FDWjtJQUVELElBQUkscUJBQXFCLENBQUMsR0FBRyxDQUFDLEtBQUssSUFBSSxFQUFFO1FBQ3ZDLE9BQU8sR0FBRyxDQUFDO0tBQ1o7SUFFRCxPQUFPLEtBQUssQ0FBQztBQUNmLENBQUMiLCJzb3VyY2VzQ29udGVudCI6WyJleHBvcnQgZnVuY3Rpb24gaXNPYmplY3QobzogYW55KTogYm9vbGVhbiB7XG4gIHJldHVybiAoXG4gICAgdHlwZW9mIG8gPT09ICdvYmplY3QnICYmXG4gICAgbyAhPT0gbnVsbCAmJlxuICAgIG8uY29uc3RydWN0b3IgJiZcbiAgICBPYmplY3QucHJvdG90eXBlLnRvU3RyaW5nLmNhbGwobykuc2xpY2UoOCwgLTEpID09PSAnT2JqZWN0J1xuICApO1xufVxuXG5leHBvcnQgZnVuY3Rpb24gaXNFbmFibGVkKHZhbDogYm9vbGVhbiB8IHsgZW5hYmxlZD86IGJvb2xlYW4gfSkge1xuICByZXR1cm4gdHlwZW9mIHZhbCAhPT0gJ3VuZGVmaW5lZCcgJiYgdHlwZW9mIHZhbCAhPT0gJ2Jvb2xlYW4nICYmIHZhbC5lbmFibGVkID09PSB0cnVlO1xufVxuXG5leHBvcnQgZnVuY3Rpb24gaXNTaG93RWwodmFsOiBhbnksIG9iajogYW55LCBlbDogYW55KTogYm9vbGVhbiB7XG4gIHJldHVybiAoXG4gICAgKGNvZXJjZUJvb2xlYW5Qcm9wZXJ0eSh2YWwpID09PSB0cnVlICYmIG9iaiAmJiAhb2JqLmVsKSB8fFxuICAgICEoXG4gICAgICB0eXBlb2Ygb2JqICE9PSAnYm9vbGVhbicgJiZcbiAgICAgIG9iai5lbCAhPT0gZWw/Lm5hdGl2ZUVsZW1lbnQgJiZcbiAgICAgICh0eXBlb2Ygb2JqLmVsID09PSAnc3RyaW5nJyB8fCB0eXBlb2Ygb2JqLmVsID09PSAnb2JqZWN0JylcbiAgICApXG4gICk7XG59XG5cbmV4cG9ydCBmdW5jdGlvbiBleHRlbmQodGFyZ2V0OiBhbnksIHNyYzogYW55KSB7XG4gIGNvbnN0IG5vRXh0ZW5kID0gWydfX3Byb3RvX18nLCAnY29uc3RydWN0b3InLCAncHJvdG90eXBlJ107XG4gIE9iamVjdC5rZXlzKHNyYylcbiAgICAuZmlsdGVyKChrZXkpID0+IG5vRXh0ZW5kLmluZGV4T2Yoa2V5KSA8IDApXG4gICAgLmZvckVhY2goKGtleSkgPT4ge1xuICAgICAgaWYgKHR5cGVvZiB0YXJnZXRba2V5XSA9PT0gJ3VuZGVmaW5lZCcpIHtcbiAgICAgICAgdGFyZ2V0W2tleV0gPSBzcmNba2V5XTtcbiAgICAgICAgcmV0dXJuO1xuICAgICAgfVxuICAgICAgaWYgKHRhcmdldFtrZXldICYmICFzcmNba2V5XSkge1xuICAgICAgICByZXR1cm47XG4gICAgICB9XG4gICAgICBpZiAoaXNPYmplY3Qoc3JjW2tleV0pICYmIGlzT2JqZWN0KHRhcmdldFtrZXldKSAmJiBPYmplY3Qua2V5cyhzcmNba2V5XSkubGVuZ3RoID4gMCkge1xuICAgICAgICBpZiAoc3JjW2tleV0uX19zd2lwZXJfXykgdGFyZ2V0W2tleV0gPSBzcmNba2V5XTtcbiAgICAgICAgZWxzZSBleHRlbmQodGFyZ2V0W2tleV0sIHNyY1trZXldKTtcbiAgICAgIH0gZWxzZSB7XG4gICAgICAgIHRhcmdldFtrZXldID0gc3JjW2tleV07XG4gICAgICB9XG4gICAgfSk7XG59XG5cbmV4cG9ydCBmdW5jdGlvbiBjb2VyY2VCb29sZWFuUHJvcGVydHkodmFsdWU6IGFueSk6IGJvb2xlYW4ge1xuICByZXR1cm4gdmFsdWUgIT0gbnVsbCAmJiBgJHt2YWx1ZX1gICE9PSAnZmFsc2UnO1xufVxuXG5leHBvcnQgY29uc3QgaWdub3JlTmdPbkNoYW5nZXMgPSBbJ3BhZ2luYXRpb24nLCAnbmF2aWdhdGlvbicsICdzY3JvbGxiYXInLCAndmlydHVhbCddO1xuXG5leHBvcnQgZnVuY3Rpb24gc2V0UHJvcGVydHkodmFsOiBhbnksIG9iaiA9IHt9KToge30gfCBmYWxzZSB7XG4gIGlmIChpc09iamVjdCh2YWwpKSB7XG4gICAgcmV0dXJuIHZhbDtcbiAgfVxuXG4gIGlmIChjb2VyY2VCb29sZWFuUHJvcGVydHkodmFsKSA9PT0gdHJ1ZSkge1xuICAgIHJldHVybiBvYmo7XG4gIH1cblxuICByZXR1cm4gZmFsc2U7XG59XG4iXX0=